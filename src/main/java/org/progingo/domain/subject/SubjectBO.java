package org.progingo.domain.subject;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SubjectBO {
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
    private SubjectKind kind;
    private String analysis;
    private Boolean isDelete;
    private Date gmtCreate;
}
