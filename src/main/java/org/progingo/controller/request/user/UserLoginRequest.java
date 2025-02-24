package org.progingo.controller.request.user;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String phone;
    private String password;
}
