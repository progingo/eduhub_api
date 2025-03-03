package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.resource.CreateResourceRequest;
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

    @PostMapping("/create")
    @RequiresAuthentication
    public JsonResult createResource(@RequestBody CreateResourceRequest createResourceRequest) {
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return resourceService.createResource(user, createResourceRequest);
    }

}
