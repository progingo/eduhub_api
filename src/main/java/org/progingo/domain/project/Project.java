package org.progingo.domain.project;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * project
 */
@Data
@Builder
public class Project implements Serializable {
    private Integer id;

    /**
     * 也是一个id，真正的id不返回给前端，取而代之的是这个key
     */
    private String key;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 所属人的username
     */
    private String possessorUsername;

    /**
     * 公开0/私有1
     */
    private Boolean isPrivate;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    private static final long serialVersionUID = 1L;
}