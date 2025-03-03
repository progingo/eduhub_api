package org.progingo.domain.resource;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * resource
 */
@Data
@Builder
public class Resource implements Serializable {
    private Long id;

    private String key;

    /**
     * 项目的key
     */
    private String projectKey;

    /**
     * 创建这个资源的用户
     */
    private String username;

    /**
     * 资源的名称
     */
    private String name;

    /**
     * 资源类型(0:ppt,1:视频)
     */
    private Integer type;

    /**
     * 是否私有(对于公开的项目，私有的资源依旧不可见。对于私有的项目，资源的私有属性意义不大)
     */
    private Boolean isPrivate;

    private Boolean isDelete;

    private Date gtmCreate;

    private Date gtmUpdate;

    private static final long serialVersionUID = 1L;
}