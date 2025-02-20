package org.progingo.controller.request;

import lombok.Data;
import org.progingo.domain.PageElement;

@Data
public class SavePPTRequest {
    private String title;
    private PageElement[] slides;
    private String viewportSize;
    private String viewportRatio;
}
