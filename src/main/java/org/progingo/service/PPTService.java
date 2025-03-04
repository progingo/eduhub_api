package org.progingo.service;

import com.alibaba.fastjson2.JSON;
import org.progingo.application.PPTInfoApp;
import org.progingo.application.ResourceApp;
import org.progingo.controller.request.ppt.CreatePPTRequest;
import org.progingo.controller.request.ppt.SavePPTRequest;
import org.progingo.dao.PptInfoDao;
import org.progingo.domain.ppt.PptInfo;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.progingo.domain.user.UserRepository;
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

    public String getPPT(Integer id){
        PptInfo pptInfo = pptInfoDao.selectByPrimaryKey(id);
        return pptInfo.getSlides();
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
