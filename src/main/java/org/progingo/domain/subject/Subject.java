package org.progingo.domain.subject;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * subject
 */
@Data
public class Subject implements Serializable {
    private Long id;

    private String key;

    private String resourceKey;

    private String title;

    private String xx1;

    private String xx2;

    private String xx3;

    private String xx4;

    private String xx5;

    private String answer;

    private Integer kind;

    private String analysis;

    private Date gmtCreate;

    private Boolean isDelete;

    private static final long serialVersionUID = 1L;
}