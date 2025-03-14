package org.progingo.controller.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ResourceVO {
    private String key; // 资源key
    private String projectKey; // 项目key
    private String username; //  创建人
    private String name; // 资源名称
    private Integer type; // 资源类型 资源类型(0:ppt,1:视频)
    private Date gmtUpdate; // 资源更新时间


}
