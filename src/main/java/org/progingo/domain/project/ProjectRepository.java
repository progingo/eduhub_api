package org.progingo.domain.project;

import org.progingo.controller.vo.ProjectMemberInfoVO;
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

    int findProjectMemberRole(String projectKey, String username);

    List<ProjectBO> findProjectByMemberUsername(String username);

    int deleteMember(String projectKey, Set<String> deleteMemberSet);
}
