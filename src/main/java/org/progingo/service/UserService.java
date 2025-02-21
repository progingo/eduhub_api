package org.progingo.service;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.progingo.application.UserApp;
import org.progingo.controller.request.UserLoginRequest;
import org.progingo.controller.request.UserSignRequest;
import org.progingo.domain.user.*;
import org.progingo.infrastructure.user.UserHelper;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserHelper userHelper;
    @Autowired
    private UserApp userApp;

    public JsonResult signUser(UserSignRequest userSignRequest) {
        User signUser = User.builder()
                .nickname(userSignRequest.getNickname())
                .password(userSignRequest.getPassword())
                .phone(userSignRequest.getPhone())
                .email(userSignRequest.getEmail())
                .build();

        ActionResult checkResult = userHelper.checkSignUser(signUser);
        if(!checkResult.isSuccess()){
            return JsonResult.fail(checkResult.getMsg());
        }

        ActionResult signResult = userApp.signUser(signUser);
        if(!signResult.isSuccess()){
           return JsonResult.fail(signResult.getMsg());
       }
        return JsonResult.ok();
    }

    public JsonResult login(UserLoginRequest userLoginRequest) {
        User loginUser = User.builder().phone(userLoginRequest.getPhone()).password(userLoginRequest.getPassword()).build();

        if (!userHelper.checkLoginUser(loginUser).isSuccess()){
            return JsonResult.fail("手机号或密码不正确");
        }

        ActionResult loginResult = userApp.login(loginUser);

        if (!loginResult.isSuccess()){
            return JsonResult.fail("手机号或密码不正确");
        }

        return JsonResult.ok(loginResult.getMsg());

    }

}
