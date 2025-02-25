package org.progingo.application;

import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.user.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProjectApp {

    @Autowired
    private ProjectRepository projectRepository;

    public ActionResult createProject(Project project){
        project.setKey(UUID.randomUUID().toString().replaceAll("-", ""));
        project.setIsDelete(false);
        boolean save = projectRepository.save(project);
        if (save){
            return ActionResult.ok(project.getKey());
        }else {
            return ActionResult.fail("创建失败");
        }

    }

}
