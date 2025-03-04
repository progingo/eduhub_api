package org.progingo.domain.project;

import org.progingo.domain.user.UserBO;

import java.util.List;
import java.util.Set;

public interface ProjectRepository {
    boolean save(Project project);

    List<ProjectBO> findProjectByPossessorUsername(String username);

    List<UserBO> findProjectMember(String projectKey);

    boolean isAdmin(String projectKey, String username);

    boolean isMember(String projectKey, String username);

    boolean isEditor(String projectKey, String username);

    int addMember(String projectKey, Set<String> addMemberSet);

    List<ProjectBO> findProjectByMemberUsername(String username);
}
