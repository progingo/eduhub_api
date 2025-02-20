package org.progingo.domain;

import lombok.Data;

@Data
public class Element {
    private String type;
    private String id;
    private Integer left;
    private Integer top;
    private Integer width;
    private Integer height;
    private Integer lineHight;
    private String content;
    private Integer rotate;
    private String defaultFontName;
    private String defaultColor;
}
