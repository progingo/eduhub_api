package org.progingo.domain.ppt;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PPTInfoBO {
    private Integer id;

    private String key;

    private String username;
    /**
     * 状态(0:正在新建，1:正常展示，2:删除)
     */
    private PPTState state;

    /**
     * 从哪个节点的基础上创建的
     */
    private String nodeKey;

    private PPTEntity pptEntity;

    private Date gmtCreate;

    private Date gmtUpdate;
}
