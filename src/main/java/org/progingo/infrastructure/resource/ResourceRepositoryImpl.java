package org.progingo.infrastructure.resource;

import org.progingo.dao.ProjectDao;
import org.progingo.dao.ProjectMemberDao;
import org.progingo.dao.ResourceDao;
import org.progingo.domain.project.ProjectExample;
import org.progingo.domain.project.ProjectMemberExample;
import org.progingo.domain.project.ProjectMemberRole;
import org.progingo.domain.resource.Resource;
import org.progingo.domain.resource.ResourceExample;
import org.progingo.domain.resource.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectMemberDao projectMemberDao;

    @Override
    public boolean save(Resource resource) {
        resource.setGtmCreate(new Date());
        resource.setGtmUpdate(new Date());
        int r = resourceDao.insert(resource);
        return r == 1;

    }

    @Override
    public boolean isEditor(String resourceKey, String username) {
        ResourceExample resourceExample = new ResourceExample();
        resourceExample.createCriteria()
                .andKeyEqualTo(resourceKey);
        Resource resource = resourceDao.selectByExample(resourceExample).stream().findFirst().orElse(null);
        if (resource == null)
            return false;

        String projectKey = resource.getProjectKey();

        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andKeyEqualTo(projectKey);
        long projectNumber = projectDao.countByExample(projectExample);

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleEqualTo(ProjectMemberRole.ADMIN.getCode())
                .andIsDeleteEqualTo(false);

        projectMemberExample.or()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleEqualTo(ProjectMemberRole.MEMBER.getCode())
                .andIsDeleteEqualTo(false);

        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);

        return projectNumber + projectMemberNumber > 0;
    }
}
