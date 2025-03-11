package org.progingo.application;

import org.progingo.controller.vo.ResourceVO;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.resource.Resource;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Component
public class ResourceApp {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public ActionResult addResource(Resource resource) {
        String key = UUID.randomUUID().toString().replaceAll("-", "");
        resource.setKey(key);
        resource.setIsDelete(false);

        boolean save = resourceRepository.save(resource);
        if (save){
            return ActionResult.ok(key);
        }else {
            return ActionResult.fail("资源创建失败");
        }

    }



    /**
     *  删除资源
     * @param resourceKey
     * @param user
     * @return
     */
    public ActionResult deleteResource(String resourceKey, UserBO user) {
        // 获取该资源的项目key
        String projectKey = resourceRepository.getProjectKey(resourceKey);

        // 检查用户是否是项目成员
        if (!projectRepository.isMember(projectKey, user.getUsername())) {
            return ActionResult.fail("您不是该项目成员，无法删除该资源");
        }

        // 检查用户是否有权限删除资源（管理员或编辑者）
        boolean hasPermission = projectRepository.isAdmin(projectKey, user.getUsername())
                || resourceRepository.isEditor(resourceKey, user.getUsername());

        if (!hasPermission) {
            return ActionResult.fail("您没有权限删除该资源");
        }

        // 删除资源
        boolean isDeleted = resourceRepository.reviseResource(resourceKey);

        if (isDeleted) {
            return ActionResult.ok("删除成功");
        } else {
            return ActionResult.fail("删除失败");
        }
    }
}
