package org.progingo.domain.ppt;

import java.util.List;

public interface PPTGitTreeRepository {

    boolean addTreeNode(PptGitTreeBO pptGitTreeBO);

    String findPPTKeyByNodeKey(String nodeKey);

    String findResourceKeyByNodeKey(String nodeKey);

    PptGitTreeBO findByKey(String nodeKey);

    List<PptGitTreeBO> childrenNode(String nodeKey);
}
