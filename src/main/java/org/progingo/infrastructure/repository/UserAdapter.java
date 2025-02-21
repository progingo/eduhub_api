package org.progingo.infrastructure.repository;

import org.progingo.domain.user.User;
import org.progingo.domain.user.UserBO;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {
    public UserBO toBo(User user) {
        return UserBO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}
