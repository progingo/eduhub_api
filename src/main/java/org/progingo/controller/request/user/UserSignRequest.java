package org.progingo.controller.request.user;

import lombok.Data;

@Data
public class UserSignRequest {
    private String nickname;
    private String password;
    private String phone;
    private String email;
}
