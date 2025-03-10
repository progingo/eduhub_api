package org.progingo.service;

import com.alibaba.fastjson2.JSON;
import org.progingo.application.PPTInfoApp;
import org.progingo.application.ResourceApp;
import org.progingo.controller.request.ppt.CreatePPTRequest;
import org.progingo.controller.request.ppt.SavePPTRequest;
import org.progingo.controller.vo.PPTInfoVO;
import org.progingo.dao.PptInfoDao;
import org.progingo.domain.ppt.*;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.progingo.domain.user.UserRepository;
import org.progingo.infrastructure.ppt.PPTInfoAdapter;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void savePPT(SavePPTRequest savePPTRequest){

        String jsonString = JSON.toJSONString(savePPTRequest.getSlides());
        //System.out.println(jsonString);

        PptInfo pptInfo = PptInfo.builder()
                .title(savePPTRequest.getTitle())
                .slides(jsonString)
                .viewportsize(savePPTRequest.getViewportSize())
                .viewportratio(savePPTRequest.getViewportRatio())
                .build();

        pptInfoDao.insert(pptInfo);
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
}
