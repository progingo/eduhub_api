package org.progingo.controller.request;

import lombok.Data;

@Data
public class UserUpdateBaseInfoRequest {
    private String nickname;
    private String email;
}
