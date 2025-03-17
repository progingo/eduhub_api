package org.progingo.infrastructure.ppt;

import org.progingo.application.PPTGitTreeApp;
import org.progingo.domain.ppt.PptGitTreeBO;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PPTHelper {

    @Autowired
    private PPTGitTreeApp pptGitTreeApp;

    public ActionResult checkMergeNode(PptGitTreeBO node1, PptGitTreeBO node2){
        if (node1 == null || node2 == null){
            return ActionResult.fail("节点不存在");
        }

        //检查是否是同一个资源的节点
        if (!node1.getResourceKey().equals(node2.getResourceKey())){
            return ActionResult.fail("节点不在同一个资源中");
        }

        //检查是否存在父子关系
        boolean haveConsanguinity = pptGitTreeApp.checkConsanguinity(node1.getKey(), node2.getKey());
        if(haveConsanguinity){
            return ActionResult.fail("两个节点不能是自己或子孙关系");
        }

        return ActionResult.ok();
    }
}
