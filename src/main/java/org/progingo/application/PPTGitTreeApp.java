package org.progingo.application;

import org.progingo.domain.ppt.PPTGitTreeRepository;
import org.progingo.domain.ppt.PPTTreeOperation;
import org.progingo.domain.ppt.PptGitTreeBO;
import org.progingo.domain.user.ActionResult;
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
}
