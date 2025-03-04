package org.progingo.controller.request.project;

import lombok.Data;

/**
 * ReviseRoleRequest
 * 修改成员角色请求
 */
@Data
public class ReviseRoleRequest {

    /*
     * 项目key
     */
    private String projectKey;
    /*
     * 成员用户名
     */
    private String username;
    /*
     * 成员角色
     * 0:普通成员(不可编辑),1:普通成员(组员,可编辑),2:管理员
     */
    private Integer role;
}
