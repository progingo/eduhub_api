package org.progingo.infrastructure.ppt;

import org.progingo.dao.PptGitTreeDao;
import org.progingo.domain.PptGitTree;
import org.progingo.domain.PptGitTreeExample;
import org.progingo.domain.ppt.PPTGitTreeRepository;
import org.progingo.domain.ppt.PptGitTreeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class PPTGitTreeRepositoryImpl implements PPTGitTreeRepository {

    @Autowired
    private PptGitTreeDao pptGitTreeDao;

    @Override
    public boolean addTreeNode(PptGitTreeBO pptGitTreeBO) {

        PptGitTree pptGitTree = adapter(pptGitTreeBO);
        pptGitTree.setGmtCreate(new Date());
        pptGitTree.setGmtUpdate(new Date());
        int r = pptGitTreeDao.insert(pptGitTree);
        return r == 1;
    }

    @Override
    public String findPPTKeyByNodeKey(String nodeKey) {
        PptGitTreeExample pptGitTreeExample = new PptGitTreeExample();
        pptGitTreeExample.createCriteria()
                .andKeyEqualTo(nodeKey)
                .andIsDeleteEqualTo(false);
        PptGitTree pptGitTree = pptGitTreeDao.selectByExample(pptGitTreeExample).stream().findFirst().orElse(null);
        if (pptGitTree == null){
            return null;
        }
        return pptGitTree.getPptKey();
    }

    private PptGitTree adapter(PptGitTreeBO pptGitTreeBO) {
        PptGitTree pptGitTree = new PptGitTree();
        pptGitTree.setId(pptGitTreeBO.getId());
        pptGitTree.setKey(pptGitTreeBO.getKey());
        pptGitTree.setRemark(pptGitTreeBO.getRemark());
        pptGitTree.setUsername(pptGitTreeBO.getUsername());
       pptGitTree.setResourceKey(pptGitTreeBO.getResourceKey());
        pptGitTree.setPptKey(pptGitTreeBO.getPptKey());
        pptGitTree.setIsRoot(pptGitTreeBO.getIsRoot());
        pptGitTree.setOperation(pptGitTreeBO.getOperation().getCode());
        pptGitTree.setParentKey(pptGitTreeBO.getParentKey());
        pptGitTree.setMergeParentKey(pptGitTreeBO.getMergeParentKey());
        pptGitTree.setIsDelete(pptGitTreeBO.getIsDelete());
        pptGitTree.setGmtCreate(pptGitTreeBO.getGmtCreate());
        pptGitTree.setGmtUpdate(pptGitTreeBO.getGmtUpdate());
        return pptGitTree;
    }
}
