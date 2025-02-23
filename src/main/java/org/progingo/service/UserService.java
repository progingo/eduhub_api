package org.progingo.service;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.progingo.application.UserApp;
import org.progingo.controller.request.UserLoginRequest;
import org.progingo.controller.request.UserSignRequest;
import org.progingo.controller.request.UserUpdateBaseInfoRequest;
import org.progingo.controller.vo.UserInfoVO;
import org.progingo.domain.user.*;
import org.progingo.infrastructure.repository.UserAdapter;
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
    @Autowired
    private UserAdapter userAdapter;

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

    public JsonResult getUserInfo(UserBO user) {
        UserInfoVO userVO = userAdapter.toVO(user);
        if (userVO == null || userVO.getUsername() == null){
            return JsonResult.fail(401,"请重新登陆");
        }
        return JsonResult.ok(userVO);
    }


    public JsonResult updateUserBaseInfo(UserBO user, UserUpdateBaseInfoRequest userUpdateBaseInfoRequest) {
        if (user == null){
            return JsonResult.fail(401,"请重新登陆");
        }
        User updateUser = User.builder()
                .nickname(userUpdateBaseInfoRequest.getNickname())
                .email(userUpdateBaseInfoRequest.getEmail())
                .build();

        updateUser.setId(user.getId());

        ActionResult actionResult = userHelper.checkUpdateBaseInfoUser(updateUser);
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }

        actionResult = userApp.updateUser(updateUser);
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }

        return JsonResult.ok();

    }
}
