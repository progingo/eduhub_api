package org.progingo.domain.user;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserBO {
    private Integer id;

    private String username;

    private String nickname;

    private String profilePhoto;

    private String phone;

    private String email;

    private static final long serialVersionUID = 1L;

    public boolean isTourist(){
        return "".equals(username);
    }
}
