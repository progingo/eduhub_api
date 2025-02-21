package org.progingo.application;


import org.apache.shiro.crypto.hash.Md5Hash;
import org.progingo.dao.UserDao;
import org.progingo.domain.user.*;
import org.progingo.util.JsonResult;
import org.progingo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UserApp {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserRepository userRepository;

    public ActionResult signUser(User signUser){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(signUser.getPhone());
        User user = userDao.selectByExample(userExample).stream().findFirst().orElse(null);

        if (user != null){
            return ActionResult.fail(ResultCode.PHONE_EXIST);
        }
        signUser.setUsername(UUID.randomUUID().toString());
        signUser.setSalt(UUID.randomUUID().toString().replaceAll("-", ""));
        signUser.setPassword(new Md5Hash(signUser.getPassword(), signUser.getSalt(), 3).toString());
        signUser.setGmtCreate(new Date());
        signUser.setGmtModify(new Date());

        if(userRepository.saveUser(signUser)){
            return ActionResult.ok();
        }
        return ActionResult.fail("注册失败");

    }

    public ActionResult login(User loginUser) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(loginUser.getPhone());
        User user = userDao.selectByExample(userExample).stream().findFirst().orElse(null);

        if (user == null){
            return ActionResult.fail(ResultCode.LOGIN_FAIL);
        }

        String salt = user.getSalt();
        String password = new Md5Hash(loginUser.getPassword(), salt, 3).toString();
        if (!user.getPassword().equals(password)){
            return ActionResult.fail(ResultCode.LOGIN_FAIL);
        }


        UserBO userBO = UserBO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
        String token = tokenUtil.saveUserCache(userBO);
        return ActionResult.ok(token);
    }
}
