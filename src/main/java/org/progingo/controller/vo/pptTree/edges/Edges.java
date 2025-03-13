package org.progingo.controller.vo.pptTree.edges;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Edges {
    private String id;
    private String source;
    private String target;
    private boolean animated;
}
