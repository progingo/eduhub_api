package org.progingo.controller.vo;

import lombok.Builder;
import lombok.Data;
import org.progingo.domain.ppt.PPTEntity;

import java.util.Date;

@Data
@Builder
public class PPTInfoVO {

    private String title;
    private String slides;
    private String viewportsize;
    private String viewportratio;

    private Date gmtCreate;
    private Date gmtUpdate;

}
