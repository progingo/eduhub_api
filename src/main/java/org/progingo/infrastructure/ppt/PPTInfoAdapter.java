package org.progingo.infrastructure.ppt;

import org.progingo.domain.ppt.PPTEntity;
import org.progingo.domain.ppt.PPTInfoBO;
import org.progingo.domain.ppt.PPTState;
import org.progingo.domain.ppt.PptInfo;
import org.springframework.stereotype.Component;

@Component
public class PPTInfoAdapter {

    public PPTInfoBO toBO(PptInfo pptInfo){
        if (pptInfo == null){
            return null;
        }
        PPTEntity pptEntity = new PPTEntity();
        pptEntity.setTitle(pptInfo.getTitle());
        pptEntity.setSlides(pptInfo.getSlides());
        pptEntity.setViewportratio(pptInfo.getViewportratio());
        pptEntity.setViewportsize(pptInfo.getViewportsize());

        PPTInfoBO pptInfoBO = PPTInfoBO.builder()
                .id(pptInfo.getId())
                .key(pptInfo.getKey())
                .username(pptInfo.getUsername())
                .state(PPTState.getByCode(pptInfo.getState()))
                .nodeKey(pptInfo.getNodeKey())
                .pptEntity(pptEntity)
                .gmtCreate(pptInfo.getGmtCreate())
                .gmtUpdate(pptInfo.getGmtUpdate())
                .build();

        return pptInfoBO;
    }
}
