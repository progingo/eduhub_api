package org.progingo.service;

import org.progingo.application.ProjectApp;
import org.progingo.controller.request.project.*;

import org.progingo.controller.vo.ProjectMemberInfoVO;
import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectBO;
import org.progingo.domain.project.ProjectMemberRole;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.UserBO;
import org.progingo.infrastructure.project.ProjectHelper;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectHelper projectHelper;
    @Autowired
    private ProjectApp projectApp;
    @Autowired
    private ProjectRepository projectRepository;

    public JsonResult createProject(UserBO user, CreateProjectRequest createProjectRequest) {

        if (user.isTourist()){
            return JsonResult.ok(401,"请重新登陆");
        }

        Project project = Project.builder()
                .projectName(createProjectRequest.getProjectName())
                .isPrivate(createProjectRequest.getIsPrivate().equals(1))
                .build();

        ActionResult checkActionResult = projectHelper.checkCreateProject(project);
        if (!checkActionResult.isSuccess()){
            return JsonResult.fail(checkActionResult.getMsg());
        }

        ActionResult result = projectApp.createProject(user, project);
        if (!result.isSuccess()){
            return JsonResult.fail(result.getMsg());
        }

        return JsonResult.ok(result.getMsg());
    }

    /**
     * 删除项目
     * @param user
     * @param projectKey
     * @return
     */
    public JsonResult deleteProject(UserBO user, String projectKey) {
        if (user.isTourist()){
            return JsonResult.ok(401,"请重新登陆");
        }
        ActionResult actionResult = projectApp.deleteProject(user, projectKey);
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }
        return JsonResult.ok(actionResult.getMsg());
    }

    /**
     * 修改项目
     * @param user
     * @param reviseProjectRequest
     * @return
     */
    public JsonResult reviseProject(UserBO user, ReviseProjectRequest reviseProjectRequest) {
        String projectKey = reviseProjectRequest.getProjectKey();
        if (user.isTourist()){
            return JsonResult.ok(401,"请重新登陆");
        }
        if (!projectRepository.isAdmin(projectKey, user.getUsername())){
            return JsonResult.fail("您不是该项目管理员，无法修改项目");
        }
        // 把reviseRoleRequest转为ProjectBO
        ProjectBO projectBO = ProjectBO.builder()
                .key(reviseProjectRequest.getProjectKey())
                .projectName(reviseProjectRequest.getProjectName())
                .isPrivate(reviseProjectRequest.getIsPrivate().equals(1))
                .build();
        ActionResult actionResult = projectApp.reviseProject(user, projectBO);
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }
        return JsonResult.ok(actionResult.getMsg());
    }

    public JsonResult addMember(UserBO user, AddMemberRequest addMemberRequest) {
        List<UserBO> projectMemberList = projectRepository.findProjectMember(addMemberRequest.getProjectKey());
        Set<String> projectMemberIdSet = projectMemberList.stream().map(UserBO::getUsername).collect(Collectors.toSet());
        //重复的人员不会被添加
        Set<String> addMemberSet = addMemberRequest.getUsernameList()
                .stream()
                .filter(x -> !projectMemberIdSet.contains(x))
                .collect(Collectors.toSet());

        ActionResult actionResult = projectApp.addProjectMember(user, addMemberRequest.getProjectKey(), addMemberSet);
        if (!actionResult.isSuccess()) {
            return JsonResult.fail(actionResult.getMsg());
        }
        return JsonResult.ok(actionResult.getMsg());
    }
    public JsonResult deleteProjectMember(UserBO user, DeleteMemberRequest deleteMemberRequest){
        List<UserBO> projectMemberList = projectRepository.findProjectMember(deleteMemberRequest.getProjectKey());
        Set<String> projectMemberIdSet = projectMemberList.stream().map(UserBO::getUsername).collect(Collectors.toSet());
        //只有当成员为项目成员时才删除，并且不能删除自己
        Set<String> deleteMemberSet = deleteMemberRequest.getUsernameList()
                .stream()
                .filter(x -> projectMemberIdSet.contains(x) && !x.equals(user.getUsername()))
                .collect(Collectors.toSet());

        if(deleteMemberSet.isEmpty()){
            return JsonResult.fail("请选择要删除的成员");
        }

        ActionResult actionResult = projectApp.deleteProjectMember(user, deleteMemberRequest.getProjectKey(), deleteMemberSet);
        if (!actionResult.isSuccess()) {
            return JsonResult.fail(actionResult.getMsg());
        }
        return JsonResult.ok(actionResult.getMsg());


    }

    public JsonResult getProjectMember(String projectKey) {
        if(projectKey == null){
            return JsonResult.fail("项目不存在");
        }
        List<UserBO> projectMemberList = projectRepository.findProjectMember(projectKey);
        List<ProjectMemberInfoVO> projectMemberInfoVOList = projectMemberList.stream().map(x -> {
            return ProjectMemberInfoVO.builder()
                    .nickName(x.getNickname())
                    .profilePhoto(x.getProfilePhoto())
                    .role(projectRepository.findProjectMemberRole(projectKey, x.getUsername()))
                    .username(x.getUsername())
                    .build();
        }).collect(Collectors.toList());
        if (projectMemberInfoVOList.isEmpty()){
            return JsonResult.fail("项目成员为空");
        }
        return JsonResult.ok(projectMemberInfoVOList);
    }

    /**
     * 修改项目成员角色
     * @param user  当前用户
     * @param reviseRoleRequest 修改角色请求
     * @return
     */
    public JsonResult reviseRole(UserBO user, ReviseRoleRequest reviseRoleRequest) {
        String username = user.getUsername();
        String projectKey = reviseRoleRequest.getProjectKey();
        if (user.isTourist()){
            return JsonResult.ok(401,"请重新登陆");
        }
        if (!projectRepository.isAdmin(projectKey, username)){
            return JsonResult.fail("权限不足");
        }
        if (!projectRepository.isMember(projectKey, reviseRoleRequest.getUsername())){
            return JsonResult.fail("成员不存在");
        }
        ActionResult actionResult = projectApp.reviseRole(username,projectKey,
                reviseRoleRequest.getUsername(), ProjectMemberRole.getByCode(reviseRoleRequest.getRole()));

        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }
        return JsonResult.ok(actionResult.getMsg());

    }
}
