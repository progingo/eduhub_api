package org.progingo.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * resource_show_data
 */
@Data
@Builder
public class ResourceShowData implements Serializable {
    private Integer id;

    private String resourceKey;

    private String nodeKey;

    private Boolean isShow;

    private Date gmtCreate;

    private Date gmtUpdate;

    private static final long serialVersionUID = 1L;
}