package org.progingo.application;

import org.progingo.domain.resource.Resource;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.user.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ResourceApp {

    @Autowired
    private ResourceRepository resourceRepository;

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
}
