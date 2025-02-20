package org.progingo.domain;

import lombok.Data;

@Data
public class PageElement {
    private String id;
    private Object[] elements;
    private Background background;
}
