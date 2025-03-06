package org.progingo.application;

import org.progingo.domain.project.*;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.progingo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ProjectApp {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMemberRepository projectMemberRepository;
    @Autowired
    private UserRepository userRepository;

    public ActionResult createProject(UserBO userUserBO, Project project){
        project.setKey(UUID.randomUUID().toString().replaceAll("-", ""));
        project.setIsDelete(false);
        boolean save = projectRepository.save(project);
        if (!save){
            return ActionResult.fail("创建失败");
        }

        //记录创建者
        projectMemberRepository.save(project.getKey(), userUserBO.getUsername(), ProjectMemberRole.MASTER);

        return ActionResult.ok(project.getKey());
    }

    public ActionResult addProjectMember(UserBO user, String projectKey, Set<String> addMemberSet) {
        if (user.isTourist()){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }

        boolean isAdmin = projectRepository.isAdmin(projectKey, user.getUsername());
        if (!isAdmin){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }

        //添加成员
        AtomicInteger num = new AtomicInteger();
        addMemberSet.forEach(x ->{
            if (userRepository.haveUser(x)){
                boolean save = projectMemberRepository.save(projectKey, x, ProjectMemberRole.ONLY_READ_MEMBER);
                if (save){
                    num.addAndGet(1);
                }
            }
        });

        return ActionResult.ok(String.valueOf(num));

    }
    public ActionResult deleteProjectMember(UserBO user, String projectKey, Set<String> deleteMemberSet){
        ProjectMemberRole currentUserRole = ProjectMemberRole.getByCode(projectRepository.findProjectMemberRole(projectKey, user.getUsername()));
        if (user.isTourist()){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }
        boolean isAdmin = projectRepository.isAdmin(projectKey, user.getUsername());
        if (!isAdmin){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }
        //如果需要删除的成员是创建者，则不允许删除
        //如果需要删除的成员是管理员，则当前用户必须为创建者
        for (String targetUsername : deleteMemberSet) {
            ProjectMemberRole targetUserRole = ProjectMemberRole.getByCode(projectRepository.findProjectMemberRole(projectKey, targetUsername));
            if (targetUserRole == ProjectMemberRole.MASTER) {
                return ActionResult.fail("不允许删除创建者");
            }
            if (targetUserRole == ProjectMemberRole.ADMIN && currentUserRole != ProjectMemberRole.MASTER) {
                return ActionResult.fail("权限不足");
            }
        }
        //删除成员
        int num = projectRepository.deleteMember(projectKey,deleteMemberSet);
        return ActionResult.ok(String.valueOf(num));
    }

    public ActionResult reviseRole(String currentUser, String projectKey, String targetUsername, ProjectMemberRole newRole) {
        try {
            ProjectMemberRole targetUserRole = ProjectMemberRole.getByCode(projectRepository.findProjectMemberRole(projectKey, targetUsername));
            ProjectMemberRole currentUserRole = ProjectMemberRole.getByCode(projectRepository.findProjectMemberRole(projectKey, currentUser));
            if (!hasPermissionToModify(currentUserRole, targetUserRole, newRole)) {
                return ActionResult.fail("权限不足或不可修改最高权限");
            }
            projectMemberRepository.save(projectKey, targetUsername, newRole);
            return ActionResult.ok();
        } catch (Exception e) {
            return ActionResult.fail("修改失败: " + e.getMessage());
        }
    }
    private boolean hasPermissionToModify(ProjectMemberRole currentUserRole, ProjectMemberRole targetUserRole, ProjectMemberRole newRole) {
        if (newRole == ProjectMemberRole.MASTER || targetUserRole == ProjectMemberRole.MASTER) {
            return false;
        }
        if (targetUserRole == ProjectMemberRole.ADMIN || newRole == ProjectMemberRole.ADMIN) {
            return currentUserRole == ProjectMemberRole.MASTER;
        }
        return true;
    }

}
