package org.progingo.domain.project;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * project_member
 */
@Data
@Builder
public class ProjectMember implements Serializable {
    private Long id;

    private String projectKey;

    private String username;

    /**
     * 0:普通成员(不可编辑),1:普通成员(组员,可编辑),2:管理员
     */
    private Integer role;

    private Boolean isDelete;

    private Date gmtCreate;

    private Date gmtUpdate;

    private static final long serialVersionUID = 1L;
}