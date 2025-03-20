package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.resource.CreateResourceRequest;
import org.progingo.controller.request.resource.GetResourceListRequest;
import org.progingo.controller.request.resource.ResourceRequest;
import org.progingo.controller.request.resource.UpdateShowResourceRequest;
import org.progingo.domain.user.UserBO;
import org.progingo.service.ResourceService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 创建资源
     * @param createResourceRequest
     * @return
     */
    @PostMapping("/create")
    @RequiresAuthentication
    public JsonResult createResource(@RequestBody CreateResourceRequest createResourceRequest) {
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return resourceService.createResource(user, createResourceRequest);
    }

    /**
     * 获取资源列表
     * @param getResourceListRequest
     * @return
     */
    @PostMapping("/getList")
    @RequiresAuthentication
    public JsonResult getResourceList(@RequestBody GetResourceListRequest getResourceListRequest) {
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return resourceService.getResourceList(user, getResourceListRequest);
    }

    /**
     * 删除资源
     * @param resourceRequest
     * @return
     */
    @PostMapping("/delete")
    @RequiresAuthentication
    public JsonResult deleteResource(@RequestBody ResourceRequest resourceRequest) {
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return resourceService.deleteResource(user, resourceRequest.getResourceKey());
    }

    /**
     * 获取一个资源的“资源展示”内容
     * @return
     */
    @GetMapping("/{resourceKey}/showResource")
    public JsonResult getShowResourceData(@PathVariable String resourceKey){
        return resourceService.getShowResourceData(resourceKey);
    }

    @PutMapping("/updateShowData")
    @RequiresAuthentication
    public JsonResult updateShowResourceData(@RequestBody UpdateShowResourceRequest updateShowResourceRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return resourceService.updateResourceShowState(user, updateShowResourceRequest);
    }

}
