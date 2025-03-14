package org.progingo.infrastructure.ppt;

import org.progingo.domain.PptGitTree;
import org.progingo.domain.ppt.PPTTreeOperation;
import org.progingo.domain.ppt.PptGitTreeBO;
import org.springframework.stereotype.Component;

@Component
public class PPTGitTreeAdapter {

    public PptGitTreeBO toBO(PptGitTree pptGitTree){
        if (pptGitTree == null)
            return null;

        return PptGitTreeBO.builder()
                .id(pptGitTree.getId())
                .key(pptGitTree.getKey())
                .remark(pptGitTree.getRemark())
                .username(pptGitTree.getUsername())
                .resourceKey(pptGitTree.getResourceKey())
                .pptKey(pptGitTree.getPptKey())
                .isRoot(pptGitTree.getIsRoot())
                .operation(PPTTreeOperation.getByCode(pptGitTree.getOperation()))
                .parentKey(pptGitTree.getParentKey())
                .mergeParentKey(pptGitTree.getMergeParentKey())
                .isDelete(pptGitTree.getIsDelete())
                .gmtCreate(pptGitTree.getGmtCreate())
                .gmtUpdate(pptGitTree.getGmtUpdate())
                .build();
    }
}
