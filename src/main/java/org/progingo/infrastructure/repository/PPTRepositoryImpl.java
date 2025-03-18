package org.progingo.infrastructure.repository;

import org.progingo.application.PPTGitTreeApp;
import org.progingo.application.UserApp;
import org.progingo.controller.vo.MyEditedPPTVO;
import org.progingo.controller.vo.UserInfoVO;
import org.progingo.dao.PptInfoDao;
import org.progingo.domain.ppt.*;
import org.progingo.domain.user.UserBO;
import org.progingo.infrastructure.ppt.PPTInfoAdapter;
import org.progingo.service.UserService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PPTRepositoryImpl implements PPTRepository {

    @Autowired
    private PptInfoDao pptInfoDao;
    @Autowired
    private PPTInfoAdapter pptInfoAdapter;
    @Autowired
    private UserAdapter userAdapter;
    @Autowired
    private PPTGitTreeApp pptGitTreeApp;

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

    /**
     * 获取用户正在编辑的ppt信息
     * @param user
     * @return
     */
    @Override
    public List<MyEditedPPTVO> getMyEditedPPT(UserBO user) {
        List<PptInfo> creatingPptList = getCreatingPptList(user.getUsername());
        if (creatingPptList.isEmpty()) {
            return Collections.emptyList();
        }

        UserInfoVO userVO = convertToUserVO(user);
        Map<String, PptGitTreeBO> nodeInfoMap = batchGetNodeInfo(creatingPptList);

        return creatingPptList.stream()
                .map(pptInfo -> buildMyEditedPPTVO(pptInfo, userVO, nodeInfoMap))
                .collect(Collectors.toList());
    }

    private List<PptInfo> getCreatingPptList(String username) {
        PptInfoExample example = new PptInfoExample();
        example.createCriteria()
                .andUsernameEqualTo(username)
                .andStateEqualTo(PPTState.CREAET.getCode());
        return pptInfoDao.selectByExample(example);
    }

    private UserInfoVO convertToUserVO(UserBO user) {
        return userAdapter.toVO(user);
    }

    private Map<String, PptGitTreeBO> batchGetNodeInfo(List<PptInfo> pptList) {
        Set<String> nodeKeys = pptList.stream()
                .map(PptInfo::getNodeKey)
                .collect(Collectors.toSet());
        return pptGitTreeApp.batchGetNodeInfo(nodeKeys);
    }

    private MyEditedPPTVO buildMyEditedPPTVO(PptInfo pptInfo, UserInfoVO userVO, Map<String, PptGitTreeBO> nodeInfoMap) {
        PptGitTreeBO nodeInfo = nodeInfoMap.getOrDefault(pptInfo.getNodeKey(),
                PptGitTreeBO.builder()
                        .remark("") // 默认值
                        .build());

        return MyEditedPPTVO.builder()
                .userInfoVO(userVO)
                .key(pptInfo.getKey())
                .nodeRemark(nodeInfo.getRemark())
                .nodeKey(pptInfo.getNodeKey())
                .title(pptInfo.getTitle())
                .gmtCreate(pptInfo.getGmtCreate())
                .gmtUpdate(pptInfo.getGmtUpdate())
                .build();
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
