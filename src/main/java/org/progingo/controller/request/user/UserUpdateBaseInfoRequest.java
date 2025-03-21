package org.progingo.controller.request.user;

import lombok.Data;

@Data
public class UserUpdateBaseInfoRequest {
    private String nickname;
    private String email;
    private String profilePhotoId;
}
