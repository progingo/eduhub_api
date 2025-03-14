package org.progingo.service;

import com.alibaba.fastjson2.JSON;
import org.progingo.application.PPTGitTreeApp;
import org.progingo.application.PPTInfoApp;
import org.progingo.controller.request.ppt.CommitPPTRequest;
import org.progingo.controller.request.ppt.CreatePPTRequest;
import org.progingo.controller.request.ppt.SavePPTRequest;
import org.progingo.controller.vo.PPTInfoVO;
import org.progingo.dao.PptInfoDao;
import org.progingo.domain.ppt.*;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.progingo.infrastructure.ppt.PPTInfoAdapter;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PPTService {

    @Autowired
    private PptInfoDao pptInfoDao;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private PPTInfoApp pptInfoApp;
    @Autowired
    private PPTRepository pptRepository;
    @Autowired
    private PPTInfoAdapter pptInfoAdapter;
    @Autowired
    private PPTGitTreeApp pptGitTreeApp;
    @Autowired
    private PPTGitTreeRepository pptGitTreeRepository;

    public JsonResult savePPT(UserBO user, SavePPTRequest savePPTRequest){
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }
        String jsonString = JSON.toJSONString(savePPTRequest.getSlides());
        PPTEntity pptEntity = new PPTEntity();
        pptEntity.setTitle(savePPTRequest.getTitle());
        pptEntity.setSlides(jsonString);
        pptEntity.setViewportsize(savePPTRequest.getViewportSize());
        pptEntity.setViewportratio(savePPTRequest.getViewportRatio());

        PPTInfoBO pptInfoBO = PPTInfoBO.builder()
                .key(savePPTRequest.getKey())
                .pptEntity(pptEntity)
                .build();


        ActionResult savePPTActionResult = pptInfoApp.updatePPT(user.getUsername(), pptInfoBO);

        if (!savePPTActionResult.isSuccess()){
            return JsonResult.fail(savePPTActionResult.getMsg());
        }
        return JsonResult.ok();
    }

    public JsonResult getPPT(UserBO user, String key){
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }

        PPTInfoBO pptInfoBO = pptRepository.findPPTInfoByKey(key);
        if (pptInfoBO == null || !pptInfoBO.getUsername().equals(user.getUsername()) || pptInfoBO.getState() != PPTState.NORMAL){
            return JsonResult.fail(ResultCode.PPT_NOT_EXIST.getMsg());
        }

        PPTInfoVO pptVO = pptInfoAdapter.toVO(pptInfoBO);

        return JsonResult.ok(pptVO);
    }


    public JsonResult createPPT(UserBO user, CreatePPTRequest createPPTRequest) {
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }

        boolean isEditor = resourceRepository.isEditor(createPPTRequest.getResourceKey(), user.getUsername());
        if (!isEditor) {
            return JsonResult.fail(ResultCode.PERMISSION_DENIED.getMsg());
        }

        ActionResult createPPTActionResult = pptInfoApp.createPPT(user.getUsername(), createPPTRequest.getNodeKey());
        if (!createPPTActionResult.isSuccess()){
            return JsonResult.fail(createPPTActionResult.getMsg());
        }

        return JsonResult.ok(createPPTActionResult.getMsg());

    }

    /*
    提交ppt需要先保存PPT再提交成新节点
     */
    public JsonResult commitPPT(UserBO user, CommitPPTRequest commitPPTRequest) {
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }
        String jsonString = JSON.toJSONString(commitPPTRequest.getSlides());
        PPTEntity pptEntity = new PPTEntity();
        pptEntity.setTitle(commitPPTRequest.getTitle());
        pptEntity.setSlides(jsonString);
        pptEntity.setViewportsize(commitPPTRequest.getViewportSize());
        pptEntity.setViewportratio(commitPPTRequest.getViewportRatio());

        PPTInfoBO pptInfoBO = PPTInfoBO.builder()
                .key(commitPPTRequest.getKey())
                .pptEntity(pptEntity)
                .build();


        //保存成新的ppt
        ActionResult savePPTActionResult = pptInfoApp.createPPT(user.getUsername(), pptInfoBO);

        if (!savePPTActionResult.isSuccess()){
            return JsonResult.fail(savePPTActionResult.getMsg());
        }
        String pptKey = savePPTActionResult.getMsg();

        //新建节点


        ActionResult createActionResult = pptGitTreeApp.createNode(user.getUsername(), commitPPTRequest.getKey(), pptKey, commitPPTRequest.getRemark());
        if (!createActionResult.isSuccess()){
            return JsonResult.fail(createActionResult.getMsg());
        }

        //初始化完成ppt

        String nodeKey = createActionResult.getMsg();
        ActionResult actionResult = pptInfoApp.finishInitPPT(pptKey, nodeKey);
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }

        return JsonResult.ok();

    }

    public JsonResult getPPTTree(UserBO user, String resourceKey) {
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }
        boolean editor = resourceRepository.isEditor(resourceKey, user.getUsername());
        if (!editor){
            return JsonResult.fail("权限不足");
        }

        Object[] tree = pptGitTreeApp.getTree(resourceKey);

        return JsonResult.ok(tree);

    }

    public JsonResult getMergePPT(UserBO user, String key1, String key2) {
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }

        PptGitTreeBO node1 = pptGitTreeRepository.findByKey(key1);
        PptGitTreeBO node2 = pptGitTreeRepository.findByKey(key2);

        if (node1 == null || node2 == null){
            return JsonResult.fail("节点不存在");
        }

        //检查是否是同一个资源的节点
        if (!node1.getResourceKey().equals(node2.getResourceKey())){
            return JsonResult.fail("节点不在同一个资源中");
        }

        if (!resourceRepository.isEditor(user.getUsername(), node1.getResourceKey())){
            return JsonResult.fail("权限不足");
        }

        //检查是否存在父子关系
        boolean haveConsanguinity = pptGitTreeApp.checkConsanguinity(node1.getKey(), node2.getKey());
        if(haveConsanguinity){
            return JsonResult.fail("两个节点不能是自己或子孙关系");
        }

        //获取两个节点内容
        PPTInfoBO pptInfo1 = pptRepository.findPPTInfoByKey(node1.getPptKey());
        PPTInfoBO pptInfo2 = pptRepository.findPPTInfoByKey(node2.getPptKey());
        ArrayList<String> datas = new ArrayList<>();
        datas.add(pptInfo1.getPptEntity().getSlides());
        datas.add(pptInfo2.getPptEntity().getSlides());

        return JsonResult.ok(datas);

    }
}
