package org.progingo.domain.project;

import java.util.Set;

public interface ProjectMemberRepository {

    boolean save(String projectKey, String username, ProjectMemberRole role);

    boolean delete(String projectKey, String username);
}
