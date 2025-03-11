package org.progingo.controller.request.project;

import lombok.Data;

@Data
public class ReviseProjectRequest {
    private String projectKey;
    private String projectName;
    private Integer isPrivate;
}
