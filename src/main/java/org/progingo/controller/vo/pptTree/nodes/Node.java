package org.progingo.controller.vo.pptTree.nodes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Node {

    private String id;
    private NodeData data;
    private String type;
    private String label;
    private Position position;

    private int level;
    private int ind;//该节点在当前层的第几个
}




