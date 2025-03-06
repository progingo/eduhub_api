package org.progingo.infrastructure.resource;

import org.progingo.controller.request.resource.CreateResourceRequest;
import org.progingo.domain.resource.ResourceType;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourceHelper {

    @Autowired
    private ProjectDao projectDao;

    public ActionResult checkCreateResource(CreateResourceRequest createResourceRequest) {
        if (createResourceRequest.getResourceName() == null ||
                createResourceRequest.getResourceType() == null ||
                createResourceRequest.getIsPrivate() == null){
            return ActionResult.fail("参数错误");
        }

        if (createResourceRequest.getResourceName().isEmpty()){
            return ActionResult.fail("资源名称不能为空");
        }if (createResourceRequest.getResourceName().length() > 30){
            return ActionResult.fail("资源名称不能大于30字符");
        }

        if(ResourceType.getByCode(createResourceRequest.getResourceType()) == null){
            return ActionResult.fail("参数错误");
        }

        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andKeyEqualTo(createResourceRequest.getProjectKey())
                .andIsDeleteEqualTo(false);
        long num = projectDao.countByExample(projectExample);
        if (num != 1){
            return ActionResult.fail(ResultCode.PROJECT_NOT_EXIST);
        }
        return ActionResult.ok();
    }

}
