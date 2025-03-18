package org.progingo.controller.vo;

import lombok.Builder;
import lombok.Data;
import org.apache.juli.DateFormatCache;
import org.progingo.domain.PptGitTree;

import java.util.Date;

@Data
@Builder
public class MyEditedPPTVO {
    private UserInfoVO userInfoVO; // 用户信息
    private String key; // ppt key
    private String nodeRemark; // 节点描述
    private String nodeKey; // 节点key
    private String title;// ppt标题
    private Date gmtCreate; // 创建时间

    private Date gmtUpdate; // 更新时间
}
