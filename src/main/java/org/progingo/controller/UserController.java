package org.progingo.controller;

import org.progingo.controller.request.UserLoginRequest;
import org.progingo.controller.request.UserSignRequest;
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
}
