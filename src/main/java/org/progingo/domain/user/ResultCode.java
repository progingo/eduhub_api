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
    PERMISSION_DENIED("权限不足"),

    PROJECT_NOT_EXIST("项目不存在"),
    RESOURCE_NOT_EXITS("资源不存在"),
    NODE_NOT_EXIST("节点不存在"),

    ;

    @Getter
    private final String msg;

    ResultCode(String msg) {
        this.msg = msg;
    }


}
