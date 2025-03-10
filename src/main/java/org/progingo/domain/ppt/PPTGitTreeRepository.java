package org.progingo.domain.ppt;

public interface PPTGitTreeRepository {

    boolean addTreeNode(PptGitTreeBO pptGitTreeBO);

    String findPPTKeyByNodeKey(String nodeKey);

    String findResourceKeyByNodeKey(String nodeKey);
}
