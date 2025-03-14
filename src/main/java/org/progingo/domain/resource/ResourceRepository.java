package org.progingo.domain.resource;

import org.progingo.controller.vo.ResourceVO;

import java.util.List;

public interface ResourceRepository {


    boolean save(Resource resource);

    boolean isEditor(String resourceKey, String username);

    List<ResourceVO> getResourceList(String projectKey, Boolean isMember);
    // 删除资源
    boolean reviseResource(String resourceKey);

    String getProjectKey(String resourceKey);

}
