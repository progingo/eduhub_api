package org.progingo.infrastructure.repository;

import org.progingo.dao.ProjectMemberDao;
import org.progingo.domain.project.ProjectMember;
import org.progingo.domain.project.ProjectMemberExample;
import org.progingo.domain.project.ProjectMemberRepository;
import org.progingo.domain.project.ProjectMemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public class ProjectMemberRepositoryImpl implements ProjectMemberRepository {

    @Autowired
    private ProjectMemberDao projectMemberDao;

    @Override
    public boolean save(String projectKey, String username, ProjectMemberRole role) {

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);

        long num = projectMemberDao.countByExample(projectMemberExample);
        if (num == 0){
            ProjectMember projectMember = ProjectMember.builder()
                    .username(username)
                    .projectKey(projectKey)
                    .role(role.getCode())
                    .isDelete(false)
                    .gmtCreate(new Date())
                    .gmtUpdate(new Date())
                    .build();
            return projectMemberDao.insert(projectMember) > 0;
        }else{
            ProjectMember projectMember = ProjectMember.builder()
                    .role(role.getCode())
                    .gmtUpdate(new Date())
                    .build();
            return projectMemberDao.updateByExampleSelective(projectMember, projectMemberExample) > 0;
        }

    }

    @Override
    public boolean delete(String projectKey, String username) {
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);

        long num = projectMemberDao.countByExample(projectMemberExample);
        if (num != 0){
            ProjectMember projectMember = ProjectMember.builder()
                    .isDelete(true)
                    .gmtUpdate(new Date())
                    .build();
            return projectMemberDao.updateByExampleSelective(projectMember, projectMemberExample) > 0;
        }

        return false;
    }


}
