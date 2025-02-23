package org.progingo.infrastructure.repository;

import org.progingo.controller.vo.UserInfoVO;
import org.progingo.domain.user.User;
import org.progingo.domain.user.UserBO;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {
    public UserBO toBO(User user) {
        if (user == null)
            return null;
        return UserBO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }

    public UserInfoVO toVO(UserBO user){
        if (user == null)
            return null;
        UserInfoVO userVO = UserInfoVO.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
        return userVO;
    }
}
