package org.progingo.service;

import cn.hutool.core.util.BooleanUtil;
import org.progingo.application.ProjectApp;
import org.progingo.controller.request.project.AddMemberRequest;
import org.progingo.controller.request.project.CreateProjectRequest;
import org.progingo.controller.request.project.ReviseRoleRequest;
import org.progingo.dao.UserDao;
import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.UserBO;
import org.progingo.domain.user.UserExample;
import org.progingo.infrastructure.project.ProjectHelper;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProjectService {

    @Autowired
    private ProjectHelper projectHelper;
    @Autowired
    private ProjectApp projectApp;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserDao userDao;

    public JsonResult createProject(UserBO user, CreateProjectRequest createProjectRequest) {
        String username = user.getUsername();
        if (username.isEmpty()){
            return JsonResult.ok(401,"请重新登陆");
        }
        System.out.println(createProjectRequest.getIsPrivate().equals(1));
        Project project = Project.builder()
                .projectName(createProjectRequest.getProjectName())
                .isPrivate(createProjectRequest.getIsPrivate().equals(1))
                .build();

        ActionResult checkActionResult = projectHelper.checkCreateProject(project);
        if (!checkActionResult.isSuccess()){
            return JsonResult.fail(checkActionResult.getMsg());
        }

        project.setPossessorUsername(username);

        ActionResult result = projectApp.createProject(project);
        if (!result.isSuccess()){
            return JsonResult.fail(result.getMsg());
        }

        return JsonResult.ok(result.getMsg());
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

    public JsonResult getProject(String projectKey) {
        if(projectKey == null){
            return JsonResult.fail("项目不存在");
        }
        List<UserBO> projectMemberList = projectRepository.findProjectMember(projectKey);
        if (projectMemberList.isEmpty()){
            return JsonResult.fail("项目成员为空");
        }
        return JsonResult.ok(projectMemberList);
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
        if (username.isEmpty()){
            return JsonResult.ok(401,"请重新登陆");
        }
        if (!projectRepository.isAdmin(projectKey, username)){
            return JsonResult.fail("权限不足");
        }
        if (!projectRepository.isMember(projectKey, reviseRoleRequest.getUsername())){
            return JsonResult.fail("成员不存在");
        }
        ActionResult actionResult = projectApp.reviseRole(user,projectKey,
                reviseRoleRequest.getUsername(), reviseRoleRequest.getRole());
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }
        return JsonResult.ok(actionResult.getMsg());

    }
}
