package org.progingo.infrastructure.repository;

import org.progingo.dao.PptInfoDao;
import org.progingo.domain.ppt.*;
import org.progingo.infrastructure.ppt.PPTInfoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class PPTRepositoryImpl implements PPTRepository {

    @Autowired
    private PptInfoDao pptInfoDao;
    @Autowired
    private PPTInfoAdapter pptInfoAdapter;

    @Override
    public boolean addPPTInfo(PPTInfoBO pptInfoBO) {
        PptInfo pptInfo = adapter(pptInfoBO);
        pptInfo.setGmtCreate(new Date());
        pptInfo.setGmtUpdate(new Date());
        int r = pptInfoDao.insert(pptInfo);

        return r == 1;
    }

    @Override
    public PPTInfoBO findPPTInfoByKey(String key) {
        PptInfoExample pptInfoExample = new PptInfoExample();
        pptInfoExample.createCriteria().andKeyEqualTo(key);
        PptInfo pptInfo = pptInfoDao.selectByExample(pptInfoExample).stream().findFirst().orElse(null);

        PPTInfoBO pptInfoBO = pptInfoAdapter.toBO(pptInfo);
        return pptInfoBO;
    }

    @Override
    public boolean updatePPTInfo(PPTInfoBO pptInfoBO) {
        pptInfoBO.setGmtUpdate(new Date());
        PptInfo pptInfo = adapter(pptInfoBO);
        int r = pptInfoDao.updateByPrimaryKeySelective(pptInfo);
        return r == 1;
    }

    private PptInfo adapter(PPTInfoBO pptInfoBO){

        PptInfo pptInfo = PptInfo.builder()
                .id(pptInfoBO.getId())
                .key(pptInfoBO.getKey())
                .username(pptInfoBO.getUsername())
                .nodeKey(pptInfoBO.getNodeKey())
                .state(pptInfoBO.getState().getCode())
                .title(pptInfoBO.getPptEntity().getTitle())
                .slides(pptInfoBO.getPptEntity().getSlides())
                .viewportsize(pptInfoBO.getPptEntity().getViewportsize())
                .viewportratio(pptInfoBO.getPptEntity().getViewportratio())
                .gmtCreate(pptInfoBO.getGmtCreate())
                .gmtUpdate(pptInfoBO.getGmtUpdate())
                .build();
        return pptInfo;

    }

}
