package org.progingo.controller.request;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String phone;
    private String password;
}
