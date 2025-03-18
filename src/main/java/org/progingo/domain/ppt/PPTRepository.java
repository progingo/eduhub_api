package org.progingo.domain.ppt;

import org.progingo.controller.vo.MyEditedPPTVO;
import org.progingo.controller.vo.PPTInfoVO;
import org.progingo.domain.user.UserBO;

import java.util.List;

public interface PPTRepository {
    boolean addPPTInfo(PPTInfoBO pptInfoBO);
    PPTInfoBO findPPTInfoByKey(String key);

    boolean updatePPTInfo(PPTInfoBO pptInfoBO);
    List<MyEditedPPTVO> getMyEditedPPT(UserBO userBO);
}
