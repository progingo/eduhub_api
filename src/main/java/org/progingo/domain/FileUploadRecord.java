package org.progingo.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * file_upload_record
 */
@Data
@Builder
public class FileUploadRecord implements Serializable {
    private Long id;

    /**
     * 环境
     */
    private String env;

    /**
     * 路径
     */
    private String url;

    private String username;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}