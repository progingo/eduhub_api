package org.progingo.controller.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoVO {
    private String username;

    private String nickname;

    private String phone;

    private String email;
}
