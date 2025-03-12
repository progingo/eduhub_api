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

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/info")
    @RequiresAuthentication
    public JsonResult userInfo(){
        UserBO user = (UserBO)SecurityUtils.getSubject().getPrincipal();
        return userService.getUserInfo(user);
    }

    @GetMapping("/getUserInfo/{username}")
    @RequiresAuthentication
    public JsonResult getUserInfo(@PathVariable String username){
        UserBO user = (UserBO)SecurityUtils.getSubject().getPrincipal();
        return userService.getUserInfoByUsername(user,username);
    }

    @PutMapping("/updateInfo")
    @RequiresAuthentication
    public JsonResult updateUserBaseInfo(@RequestBody UserUpdateBaseInfoRequest userUpdateBaseInfoRequest){
        UserBO user = (UserBO)SecurityUtils.getSubject().getPrincipal();
        return userService.updateUserBaseInfo(user,userUpdateBaseInfoRequest);
    }

    /**
     * 获取username用户创建的项目
     * @param username 被查看的那个人，也就是查看username这个人创建的项目
     * @return
     */
    @GetMapping("/getCreateProject/{username}")
    @RequiresAuthentication
    public JsonResult getCreateProject(@PathVariable String username){
        UserBO user = (UserBO)SecurityUtils.getSubject().getPrincipal();
        return userService.getCreateProject(user,username);
    }

    @GetMapping("/getJoinProject")
    @RequiresAuthentication
    public JsonResult getJoinProject(){
        UserBO user = (UserBO)SecurityUtils.getSubject().getPrincipal();
        return userService.getJoinProject(user);
    }

    // 获取用户信息
    @GetMapping("/getUser/{nickName}")
    public JsonResult getUserInfoByNickName(@PathVariable String nickName){
        return userService.getUserInfoByNickName(nickName);

    }
}
