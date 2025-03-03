package org.progingo.application;

import org.progingo.domain.ppt.PPTEntity;
import org.progingo.domain.ppt.PPTInfoBO;
import org.progingo.domain.ppt.PPTRepository;
import org.progingo.domain.ppt.PPTState;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.infrastructure.ppt.PPTInfoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PPTInfoApp {

    @Autowired
    private PPTRepository pptRepository;

    public ActionResult createBlankPPt(String username) {
        //新建一个PPT
        String key = UUID.randomUUID().toString().replaceAll("-", "");
        PPTInfoBO pptInfoBO = PPTInfoBO.builder()
                .username(username)
                .key(key)
                .nodeKey("")//这个时候还没有创建节点创建树，所以暂时为""
                .pptEntity(PPTEntity.getEmptyTemplate())
                .state(PPTState.CREAET)//没有完全创建好，所以状态设为0
                .build();

        boolean res = pptRepository.addPPTInfo(pptInfoBO);

        if (!res) {
            return ActionResult.fail("新建PPT失败");
        }

        return ActionResult.ok(key);
    }


    public ActionResult finishInitPPT(String pptKey, String gitTreeKey) {
        PPTInfoBO pptInfoBO = pptRepository.findPPTInfoByKey(pptKey);
        if (pptInfoBO == null){
            return ActionResult.fail(ResultCode.RESOURCE_NOT_EXITS);
        }

        pptInfoBO.setNodeKey(gitTreeKey);
        pptInfoBO.setState(PPTState.NORMAL);

        boolean res = pptRepository.updatePPTInfo(pptInfoBO);
        if (!res){
            return ActionResult.fail("更改PPT状态失败");
        }
        return ActionResult.ok();

    }
}
