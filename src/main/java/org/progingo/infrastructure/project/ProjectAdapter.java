package org.progingo.infrastructure.project;

import org.progingo.controller.vo.ProjectVO;
import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectBO;
import org.springframework.stereotype.Component;

@Component
public class ProjectAdapter {

    public ProjectBO toBO(Project project){
        if (project == null)
            return null;
        return ProjectBO.builder()
                .id(project.getId())
                .key(project.getKey())
                .projectName(project.getProjectName())
                .isPrivate(project.getIsPrivate())
                .isDelete(project.getIsDelete())
                .gmtCreate(project.getGmtCreate())
                .build();
    }


    public ProjectVO toVO(ProjectBO projectBO){
        return ProjectVO.builder()
                .key(projectBO.getKey())
                .projectName(projectBO.getProjectName())
                .possessorUsername(projectBO.getPossessorUsername())
                .isPrivate(projectBO.getIsPrivate())
                .build();
    }
}
