package org.progingo.domain.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * user
 */
@Data
@Builder
public class User implements Serializable {
    private Integer id;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private String phone;

    private String email;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;
}