package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.project.CreateProjectRequest;
import org.progingo.domain.user.UserBO;
import org.progingo.service.ProjectService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
