package org.progingo.controller.request.resource;


import lombok.Data;

@Data
public class CreateResourceRequest {
    private String projectKey;
    private String resourceName;
    private Integer resourceType;
    private Integer isPrivate;
}
