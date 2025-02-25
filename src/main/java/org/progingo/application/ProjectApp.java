package org.progingo.application;

import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
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

    public ActionResult addProjectMember(UserBO user, String projectKey, Set<String> addMemberSet) {
        if (user.isTourist()){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }

        boolean isAdmin = projectRepository.isAdmin(projectKey, user.getUsername());
        if (!isAdmin){
            return ActionResult.fail(ResultCode.PERMISSION_DENIED);
        }

        //添加成员
        int num = projectRepository.addMember(projectKey, addMemberSet);
        return ActionResult.ok(String.valueOf(num));

    }
}
