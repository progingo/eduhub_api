package org.progingo.service;

import com.alibaba.fastjson2.JSON;
import org.progingo.controller.request.ppt.SavePPTRequest;
import org.progingo.dao.PptInfoDao;
import org.progingo.domain.ppt.PptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PPTService {

    @Autowired
    private PptInfoDao pptInfoDao;

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



}
