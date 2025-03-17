package org.progingo.controller.request.ppt;

import lombok.Data;
import org.progingo.domain.PageElement;

@Data
public class MergePPTRequest {
    private String key1;
    private String key2;

    private String title;
    private PageElement[] slides;
    private String viewportSize;
    private String viewportRatio;

}
