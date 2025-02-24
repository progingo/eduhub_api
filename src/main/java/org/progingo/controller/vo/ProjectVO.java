package org.progingo.controller.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectVO {
    /**
     * 也是一个id，真正的id不返回给前端，取而代之的是这个key
     */
    private String key;

    /**
     * 项目名称
     */
    private String objectName;

    /**
     * 所属人的username
     */
    private String possessorUsername;

    /**
     * 公开0/私有1
     */
    private Boolean isPrivate;
}
