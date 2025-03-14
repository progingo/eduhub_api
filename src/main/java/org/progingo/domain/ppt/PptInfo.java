package org.progingo.domain.ppt;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * ppt_info
 */
@Data
@Builder
public class PptInfo implements Serializable {
    private Integer id;

    private String key;

    private String username;

    /**
     * 从哪个节点的基础上创建的
     */
    private String nodeKey;

    /**
     * 状态(0:正在新建，1:正常展示，2:删除)
     */
    private Integer state;

    private String title;

    private String slides;

    private String viewportsize;

    private String viewportratio;

    private Date gmtCreate;

    private Date gmtUpdate;

    private static final long serialVersionUID = 1L;
}