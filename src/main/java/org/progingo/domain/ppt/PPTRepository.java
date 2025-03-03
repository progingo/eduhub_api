package org.progingo.domain.ppt;

public interface PPTRepository {
    boolean addPPTInfo(PPTInfoBO pptInfoBO);
    PPTInfoBO findPPTInfoByKey(String key);

    boolean updatePPTInfo(PPTInfoBO pptInfoBO);
}
