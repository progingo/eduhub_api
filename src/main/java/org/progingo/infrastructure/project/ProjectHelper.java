package org.progingo.infrastructure.project;

import org.progingo.domain.project.Project;
import org.progingo.domain.user.ActionResult;
import org.springframework.stereotype.Component;

@Component
public class ProjectHelper {
    public ActionResult checkCreateProject(Project project) {
        if (project.getObjectName() == null || project.getIsPrivate() == null){
            return ActionResult.fail("参数错误");
        }

        if (project.getObjectName().isEmpty()){
            return ActionResult.fail("项目名称不能为空");
        }if (project.getObjectName().length() > 50){
            return ActionResult.fail("项目名称不能大于50字符");
        }

        return ActionResult.ok();
    }
}
