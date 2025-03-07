package org.progingo.controller.request.project;

import lombok.Data;

@Data
public class CreateProjectRequest {

    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 公开0/私有1
     */
    private Integer isPrivate;
}
