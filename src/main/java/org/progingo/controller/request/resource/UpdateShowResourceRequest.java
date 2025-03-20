package org.progingo.controller.request.resource;

import lombok.Data;

@Data
public class UpdateShowResourceRequest {
    private String resourceKey;
    private String nodeKey;
}
