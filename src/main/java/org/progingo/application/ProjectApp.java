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
        if (user.isTourist()){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }
        boolean isAdmin = projectRepository.isAdmin(projectKey, user.getUsername());
        if (!isAdmin){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }
        //删除成员
        int num = projectRepository.deleteMember(projectKey,deleteMemberSet);
        return ActionResult.ok(String.valueOf(num));
    }

    public ActionResult reviseRole(String projectKey, String username, ProjectMemberRole projectMemberRole) {

        boolean save = projectMemberRepository.save(projectKey, username, projectMemberRole);
        if (!save){
            return ActionResult.fail("修改失败");
        }
        return ActionResult.ok();
    }
}
