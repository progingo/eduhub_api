package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.project.*;

import org.progingo.dao.ProjectMemberDao;
import org.progingo.domain.project.ProjectMember;
import org.progingo.domain.project.ProjectMemberExample;
import org.progingo.domain.user.UserBO;
import org.progingo.service.ProjectService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping ("/create")
    @RequiresAuthentication
    public JsonResult createProject(@RequestBody CreateProjectRequest createProjectRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return projectService.createProject(user,createProjectRequest);
    }

    /**
     * 删除项目
     * @param deleteProjectRequest
     * @return
     */
    @PostMapping("/delete")
    @RequiresAuthentication
    public JsonResult deleteProject(@RequestBody DeleteProjectRequest deleteProjectRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return projectService.deleteProject(user, deleteProjectRequest.getProjectKey());
    }

    /**
     * 获取项目设置信息
     * @param projectKey
     * @return
     */
    @GetMapping("/getProjectSetUp/{projectKey}")
    @RequiresAuthentication
    public JsonResult getProjectSetUp(@PathVariable String projectKey) {
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return projectService.getProjectSetUp(user, projectKey);
    }

    /**
     * 添加项目成员
     * @param addMemberRequest
     * @return
     */
    @PostMapping("/addMember")
    @RequiresAuthentication
    public JsonResult addMember(@RequestBody AddMemberRequest addMemberRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return projectService.addMember(user,addMemberRequest);
    }

    /**
     * 获取项目成员
     * @param projectKey 项目key
     * @return 项目成员
     */
    @GetMapping("/projectMember/{projectKey}")
    public JsonResult getProjectMember(@PathVariable("projectKey") String projectKey){

        return projectService.getProjectMember(projectKey);
    }

    /**
     * 修改项目信息
     * @param reviseProjectRequest
     * @return
     */
    @PostMapping("/reviseProject")
    @RequiresAuthentication
    public JsonResult reviseProject(@RequestBody ReviseProjectRequest reviseProjectRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return projectService.reviseProject(user,reviseProjectRequest);
    }
    /**
     * 修改项目角色
     * @param reviseRoleRequest 修改角色请求
     * @return 修改成功
     */
    @PostMapping("/reviseRole")
    @RequiresAuthentication
    public JsonResult reviseRole(@RequestBody ReviseRoleRequest reviseRoleRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return projectService.reviseRole(user,reviseRoleRequest);
    }

    /**
     * 删除项目成员
     * @param deleteMemberRequest 删除成员请求
     * @return
     */
    @PostMapping("/deleteMember")
    @RequiresAuthentication
    public JsonResult deleteMember(@RequestBody DeleteMemberRequest deleteMemberRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return projectService.deleteProjectMember(user,deleteMemberRequest);
    }

}
