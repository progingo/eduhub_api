package org.progingo.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * ppt_info
 */
@Data
@Builder
public class PptInfo implements Serializable {
    private Integer id;

    private String title;

    private String slides;

    private String viewportsize;

    private String viewportratio;

    private static final long serialVersionUID = 1L;
}