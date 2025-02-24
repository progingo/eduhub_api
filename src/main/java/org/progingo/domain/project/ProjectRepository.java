package org.progingo.domain.project;

import java.util.List;

public interface ProjectRepository {
    boolean save(Project project);

    List<ProjectBO> findProjectByPossessorUsername(String username);
}
