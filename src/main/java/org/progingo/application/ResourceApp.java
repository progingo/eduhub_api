package org.progingo.application;

import org.progingo.controller.vo.ResourceVO;
import org.progingo.dao.ResourceDao;
import org.progingo.dao.ResourceShowDataDao;
import org.progingo.domain.ResourceShowData;
import org.progingo.domain.ResourceShowDataExample;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.resource.Resource;
import org.progingo.domain.resource.ResourceExample;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ResourceApp {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private ResourceShowDataDao resourceShowDataDao;

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

    public List<String> findShowResourceData(String resourceKey) {
        ResourceExample resourceExample = new ResourceExample();
        resourceExample.createCriteria().andKeyEqualTo(resourceKey).andIsDeleteEqualTo(false);
        Resource resource = resourceDao.selectByExample(resourceExample).stream().findFirst().orElse(null);

        if (resource == null){
            return new ArrayList<>();
        }
        //
        ResourceShowDataExample resourceShowDataExample = new ResourceShowDataExample();
        resourceShowDataExample.createCriteria().andResourceKeyEqualTo(resourceKey).andIsShowEqualTo(true);
        List<String> nodeList = resourceShowDataDao.selectByExample(resourceShowDataExample)
                .stream()
                .map(ResourceShowData::getNodeKey)
                .collect(Collectors.toList());
        return nodeList;

    }

    public ActionResult updateShowState(String resourceKey, String nodeKey) {
        //如果没有记录肯定就是对资源进行展示
        ResourceShowDataExample resourceShowDataExample = new ResourceShowDataExample();
        resourceShowDataExample.createCriteria()
                .andResourceKeyEqualTo(resourceKey)
                .andNodeKeyEqualTo(nodeKey);
        ResourceShowData resourceShowData = resourceShowDataDao.selectByExample(resourceShowDataExample).stream().findFirst().orElse(null);
        if (resourceShowData == null){
            ResourceShowData newResourceShowData = ResourceShowData.builder()
                    .resourceKey(resourceKey)
                    .nodeKey(nodeKey)
                    .isShow(true)
                    .gmtCreate(new Date())
                    .gmtUpdate(new Date())
                    .build();
            int r = resourceShowDataDao.insert(newResourceShowData);
            return r == 1 ? ActionResult.ok("展示资源成功") : ActionResult.fail("更新失败");
        }else{
            ResourceShowData updateResourceShowData = ResourceShowData.builder()
                    .resourceKey(resourceShowData.getResourceKey())
                    .nodeKey(resourceShowData.getNodeKey())
                    .isShow(!resourceShowData.getIsShow())
                    .gmtUpdate(new Date())
                    .build();
            int r = resourceShowDataDao.updateByExampleSelective(updateResourceShowData, resourceShowDataExample);
            return r == 1 ? ActionResult.ok((resourceShowData.getIsShow() ? "隐藏" : "展示") + "资源成功") : ActionResult.fail("更新失败");
        }

    }
}
