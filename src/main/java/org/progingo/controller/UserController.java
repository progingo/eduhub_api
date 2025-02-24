package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.user.UserLoginRequest;
import org.progingo.controller.request.user.UserSignRequest;
import org.progingo.controller.request.user.UserUpdateBaseInfoRequest;
import org.progingo.domain.user.UserBO;
import org.progingo.service.UserService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign")
    public JsonResult signUser(@RequestBody UserSignRequest userSignRequest) {
        return JsonResult.ok(userService.signUser(userSignRequest));
    }

    @PostMapping("/login")
    public JsonResult loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        return JsonResult.ok(userService.login(userLoginRequest));
    }

    @GetMapping("/info")
    @RequiresAuthentication
    public JsonResult userInfo(){
        UserBO user = (UserBO)SecurityUtils.getSubject().getPrincipal();
        return userService.getUserInfo(user);
    }

    @PutMapping("/updateInfo")
    @RequiresAuthentication
    public JsonResult updateUserBaseInfo(@RequestBody UserUpdateBaseInfoRequest userUpdateBaseInfoRequest){
        UserBO user = (UserBO)SecurityUtils.getSubject().getPrincipal();
        return userService.updateUserBaseInfo(user,userUpdateBaseInfoRequest);
    }
}
