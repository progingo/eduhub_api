package org.progingo.domain.ppt;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ppt_git_tree
 */
@Data
@Builder
public class PptGitTreeBO implements Serializable {
    /**
     * 树节点的id
     */
    private Long id;
    /**
     * 为了提高性能，这个key需要经过特殊设计!
     */
    private String key;
    /**
     * 节点描述
     */
    private String remark;
    /**
     * 操作者
     */
    private String username;
    /**
     * 这棵树对应的资源key
     */
    private String resourceKey;
    /**
     * 该节点对应的ppt的key
     */
    private String pptKey;
    /**
     * 是否为树根
     */
    private Boolean isRoot;
    /**
     * 操作(0:创建资源时自动创建，1:用户提交，2:合并)
     */
    private PPTTreeOperation operation;
    /**
     * 父节点
     */
    private String parentKey;
    /**
     * 如果是合并操作，那么这是第二个父节点
     */
    private String mergeParentKey;

    private Boolean isDelete;

    private Date gmtCreate;

    private Date gmtUpdate;

    private static final long serialVersionUID = 1L;
}