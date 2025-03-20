package org.progingo.application;

import org.progingo.domain.ppt.*;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.infrastructure.ppt.PPTInfoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PPTInfoApp {

    @Autowired
    private PPTRepository pptRepository;
    @Autowired
    private PPTGitTreeRepository pptGitTreeRepository;

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

    public ActionResult createPPT(String username, String nodeKey) {
        //从nodeKey这个节点的基础上新建ppt，首先要找到这个节点的的ppt是哪个
        String pptKeyByNodeKey = pptGitTreeRepository.findPPTKeyByNodeKey(nodeKey);
        if (pptKeyByNodeKey == null){
            return ActionResult.fail(ResultCode.NODE_NOT_EXIST);
        }

        String key = UUID.randomUUID().toString().replaceAll("-", "");
        PPTInfoBO pptInfoByKey = pptRepository.findPPTInfoByKey(pptKeyByNodeKey);
        pptInfoByKey.setKey(key);
        pptInfoByKey.setUsername(username);
        pptInfoByKey.setState(PPTState.NORMAL);//这里不涉及其他CRUD，所以不用先设置为CREATE再设置为NORMAL

        boolean r = pptRepository.addPPTInfo(pptInfoByKey);
        if (!r){
            return ActionResult.fail("新建PPT失败");
        }
        return ActionResult.ok(key);

    }

    public ActionResult updatePPT(String username, PPTInfoBO pptInfoBO) {
        PPTInfoBO pptInfo = pptRepository.findPPTInfoByKey(pptInfoBO.getKey());
        if (pptInfo == null || !pptInfo.getUsername().equals(username)){
            return ActionResult.fail(ResultCode.PPT_NOT_EXIST);
        }
        pptInfo.setPptEntity(pptInfoBO.getPptEntity());
        pptInfo.setState(pptInfoBO.getState());

        boolean r = pptRepository.updatePPTInfo(pptInfo);
        if (!r){
            return ActionResult.fail("保存失败");
        }
        return ActionResult.ok();

    }

    public ActionResult createPPT(String username, PPTInfoBO pptInfoBO) {
        PPTInfoBO pptInfo = pptRepository.findPPTInfoByKey(pptInfoBO.getKey());
        if (pptInfo == null || !pptInfo.getUsername().equals(username)){
            return ActionResult.fail(ResultCode.PPT_NOT_EXIST);
        }

        String key = UUID.randomUUID().toString().replaceAll("-", "");

        pptInfo.setPptEntity(pptInfoBO.getPptEntity());
        pptInfo.setNodeKey("");
        pptInfo.setUsername(username);
        pptInfo.setState(PPTState.CREAET);
        pptInfo.setKey(key);

        boolean res = pptRepository.addPPTInfo(pptInfo);

        if (!res) {
            return ActionResult.fail("新建PPT失败");
        }

        return ActionResult.ok(key);

    }

    public PPTInfoBO findPPTInfoByNode(String nodeKey){
        String pptKey = pptGitTreeRepository.findPPTKeyByNodeKey(nodeKey);
        PPTInfoBO pptInfoByKey = pptRepository.findPPTInfoByKey(pptKey);
        return pptInfoByKey;

    }
}
