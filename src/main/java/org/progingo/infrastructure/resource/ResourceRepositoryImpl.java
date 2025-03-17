package org.progingo.infrastructure.resource;

import org.progingo.controller.vo.ResourceVO;
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
import java.util.List;

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
        // 获取资源信息
        Resource resource = resourceDao.selectByExample(new ResourceExample() {{
            createCriteria().andKeyEqualTo(resourceKey);
        }}).stream().findFirst().orElse(null);

        if (resource == null) {
            return false;
        }

        String projectKey = resource.getProjectKey();

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleBetween(ProjectMemberRole.MEMBER.getCode(), ProjectMemberRole.MASTER.getCode())
                .andIsDeleteEqualTo(false);
        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);
        return projectMemberNumber > 0;
    }

    /**
     * 查询资源
     * @param projectKey
     * @param isMember
     * @return
     */
    @Override
    public List<ResourceVO> getResourceList(String projectKey,  Boolean isMember) {
        ResourceExample resourceExample = new ResourceExample();
        if(isMember){
            resourceExample.createCriteria()
                    .andProjectKeyEqualTo(projectKey)
                    .andIsDeleteEqualTo(false);
        }else {
            resourceExample.createCriteria()
                    .andProjectKeyEqualTo(projectKey)
                    .andIsPrivateEqualTo(true)
                    .andIsDeleteEqualTo(false);
        }

        return resourceDao.selectByExample(resourceExample)
                .stream()
                .map(x -> ResourceVO.builder()
                        .key(x.getKey())
                        .projectKey(x.getProjectKey())
                        .username(x.getUsername())
                        .name(x.getName())
                        .type(x.getType())
                        .gmtUpdate(x.getGtmUpdate())
                        .build())
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public boolean reviseResource(String resourceKey) {
        ResourceExample resourceExample = new ResourceExample();
        resourceExample.createCriteria()
                .andKeyEqualTo(resourceKey);
        return resourceDao.updateByExampleSelective(Resource.builder().isDelete(true).build(), resourceExample) == 1;
    }

    @Override
    public String getProjectKey(String resourceKey) {
        ResourceExample resourceExample = new ResourceExample();
        resourceExample.createCriteria()
                .andKeyEqualTo(resourceKey);
        Resource resource = resourceDao.selectByExample(resourceExample).stream().findFirst().orElse(null);
        if (resource == null){
            return null;
        }
        return resource.getProjectKey();
    }
}
