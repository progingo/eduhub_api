package org.progingo.service;

import org.progingo.application.PPTGitTreeApp;
import org.progingo.application.PPTInfoApp;
import org.progingo.application.ResourceApp;
import org.progingo.controller.request.resource.CreateResourceRequest;
import org.progingo.controller.request.resource.GetResourceListRequest;
import org.progingo.controller.vo.ResourceVO;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.resource.Resource;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.resource.ResourceType;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.progingo.infrastructure.resource.ResourceHelper;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResourceService {

    @Autowired
    private ResourceHelper resourceHelper;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ResourceApp resourceApp;
    @Autowired
    private PPTInfoApp pptInfoApp;
    @Autowired
    private PPTGitTreeApp pptGitTreeApp;

    @Autowired
    private ResourceRepository resourceRepository;

    /**
     * 创建资源
     * @param user  当前用户
     * @param createResourceRequest  创建资源请求
     * @return
     */
    public JsonResult createResource(UserBO user, CreateResourceRequest createResourceRequest) {
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }

        ActionResult checkResult = resourceHelper.checkCreateResource(createResourceRequest);
        if (!checkResult.isSuccess()){
            return JsonResult.fail(checkResult.getMsg());
        }

        boolean isAdmin = projectRepository.isEditor(createResourceRequest.getProjectKey(), user.getUsername());
        if (!isAdmin){
            return JsonResult.fail(ResultCode.PERMISSION_DENIED.getMsg());
        }

        //添加资源
        Resource resource = Resource.builder()
                .username(user.getUsername())
                .projectKey(createResourceRequest.getProjectKey())
                .name(createResourceRequest.getResourceName())
                .type(createResourceRequest.getResourceType())
                .isPrivate(createResourceRequest.getIsPrivate() > 0)
                .build();
        ActionResult addResourceActionResult = resourceApp.addResource(resource);

        if (!addResourceActionResult.isSuccess()){
            return JsonResult.fail(addResourceActionResult.getMsg());
        }
        String resourceKey = addResourceActionResult.getMsg();

        //如果是PPT资源，则自动创建资源树和初始化的PPT
        if (ResourceType.getByCode(createResourceRequest.getResourceType()) == ResourceType.PPT){
            //先创建空PPT
            ActionResult createPPTResult = pptInfoApp.createBlankPPt(user.getUsername());
            //创建PPT分支合并树
            if (!createPPTResult.isSuccess()){
                return JsonResult.fail(createPPTResult.getMsg());
            }
            String pptKey = createPPTResult.getMsg();
            //创建分支树
            ActionResult initTreeActionResult = pptGitTreeApp.init(user.getUsername(), resourceKey, pptKey);
            if (!initTreeActionResult.isSuccess()){
                return JsonResult.fail(initTreeActionResult.getMsg());
            }
            //节点创建成功，现在需要修改ppt的参数和状态
            String gitTreeKey = initTreeActionResult.getMsg();
            ActionResult finishInitActionResult = pptInfoApp.finishInitPPT(pptKey, gitTreeKey);

            if (!finishInitActionResult.isSuccess()){
                return JsonResult.fail(finishInitActionResult.getMsg());
            }

            return JsonResult.ok(resourceKey);

        }

        return JsonResult.fail("创建失败");


    }

    /**
     * 获取资源列表
     */
    public JsonResult getResourceList(UserBO user, GetResourceListRequest getResourceListRequest) {
        if (user.isTourist()) {
            return JsonResult.fail(401, "请重新登陆");
        }

        if (getResourceListRequest.getProjectKey() == null) {
            return JsonResult.fail("项目为空");
        }

        boolean isMember = projectRepository.isMember(getResourceListRequest.getProjectKey(), user.getUsername());
        if (!isMember) {
            return JsonResult.fail(ResultCode.PERMISSION_DENIED.getMsg());
        }

        // 根据用户是否为项目成员决定是否获取私有资源
        List<ResourceVO> resourceList = resourceRepository.getResourceList(
                getResourceListRequest.getProjectKey(),
                isMember // 如果是成员，获取所有资源；否则只获取非私有资源
        );

        return JsonResult.ok(resourceList);
    }

    /**
     * 删除资源(伪删除)
     */
    public JsonResult deleteResource(UserBO user, String resourceKey) {
        if (user.isTourist()) {
            return JsonResult.fail(401, "请重新登陆");
        }
        ActionResult actionResult = resourceApp.deleteResource(resourceKey, user);
        if (!actionResult.isSuccess()) {
            return JsonResult.fail(actionResult.getMsg());
        }
        return JsonResult.ok(actionResult.getMsg());
    }

}
