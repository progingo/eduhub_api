package org.progingo.service;

import org.progingo.application.ProjectApp;
import org.progingo.controller.request.project.CreateProjectRequest;
import org.progingo.domain.project.Project;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.UserBO;
import org.progingo.infrastructure.project.ProjectHelper;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectHelper projectHelper;
    @Autowired
    private ProjectApp projectApp;

    public JsonResult createProject(UserBO user, CreateProjectRequest createProjectRequest) {
        String username = user.getUsername();
        if (username.isEmpty()){
            return JsonResult.ok(401,"请重新登陆");
        }
        Project project = Project.builder()
                .projectName(createProjectRequest.getProjectName())
                .isPrivate(createProjectRequest.getIsPrivate())
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
}
