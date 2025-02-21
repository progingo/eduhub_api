package org.progingo.domain.user;

import lombok.Getter;

public enum ResultCode {
    SUCCESS(""),
    FAIL(""),
    NAME_INVA("用户名格式不正确"),
    PASSWORD_INVA("密码格式不正确"),
    PHONE_INVA("手机号格式不正确"),
    EMAIL_INVA("邮箱格式不正确"),
    PHONE_EXIST("手机号已存在"),
    LOGIN_FAIL("登录失败"),

    ;

    @Getter
    private final String msg;

    private ResultCode(String msg) {
        this.msg = msg;
    }


}
