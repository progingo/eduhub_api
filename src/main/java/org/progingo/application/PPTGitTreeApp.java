package org.progingo.application;

import org.progingo.dao.PptInfoDao;
import org.progingo.domain.ppt.*;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.infrastructure.ppt.PPTGitTreeRepositoryImpl;
import org.progingo.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PPTGitTreeApp {

    @Autowired
    private MyUtil myUtil;
    @Autowired
    private PPTGitTreeRepository pptGitTreeRepository;
    @Autowired
    private PptInfoDao pptInfoDao;

    public ActionResult init(String username, String resourceKey, String pptKey) {

        String key = myUtil.nextId("ppt_git_tree_key");//我们的工具类中的这个方法正好能满足这个key所需要的条件，所以我们直接调用
        PptGitTreeBO pptGitTreeBO = PptGitTreeBO.builder()
                .remark("资源初始化创建")
                .key(key)
                .username(username)
                .resourceKey(resourceKey)
                .pptKey(pptKey)
                .isRoot(true)
                .operation(PPTTreeOperation.CREAET)
                .parentKey("")
                .mergeParentKey(null)
                .isDelete(false)
                .build();

        boolean succ = pptGitTreeRepository.addTreeNode(pptGitTreeBO);
        if (!succ){
            return ActionResult.fail("创建节点失败");
        }
        return ActionResult.ok(key);

    }

    /*
    这个pptKey要给旧的节点的key
     */
    public ActionResult createNode(String username,String oldPPTKey, String pptKey, String remark) {
        PptInfoExample pptInfoExample = new PptInfoExample();
        pptInfoExample.createCriteria().andKeyEqualTo(oldPPTKey);
        PptInfo pptInfo = pptInfoDao.selectByExample(pptInfoExample).stream().findFirst().orElse(null);
        if (pptInfo == null){
            return ActionResult.fail(ResultCode.PPT_NOT_EXIST);
        }

        String resourceKey = pptGitTreeRepository.findResourceKeyByNodeKey(pptInfo.getNodeKey());

        String nodeKey = pptInfo.getNodeKey();
        String key = myUtil.nextId("ppt_git_tree_key");//我们的工具类中的这个方法正好能满足这个key所需要的条件，所以我们直接调用
        PptGitTreeBO pptGitTreeBO = PptGitTreeBO.builder()
                .remark("资源初始化创建")
                .key(key)
                .username(username)
                .resourceKey(resourceKey)
                .pptKey(pptKey)
                .remark(remark)
                .isRoot(false)
                .operation(PPTTreeOperation.COMMIT)
                .parentKey(nodeKey)
                .mergeParentKey(null)
                .isDelete(false)
                .build();
        boolean b = pptGitTreeRepository.addTreeNode(pptGitTreeBO);

        if (!b){
            return ActionResult.fail("提交失败");
        }
        return ActionResult.ok(key);
    }
}
