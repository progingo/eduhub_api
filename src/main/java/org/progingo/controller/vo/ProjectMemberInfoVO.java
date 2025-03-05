package org.progingo.controller.vo;

import lombok.Builder;
import lombok.Data;
import okhttp3.HttpUrl;

@Data
@Builder
public class ProjectMemberInfoVO {
    private String nickName;
    private String profilePhoto;
    private Integer role;


}
