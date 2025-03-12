package org.progingo.application;


import org.apache.shiro.crypto.hash.Md5Hash;
import org.progingo.controller.vo.UserInfoVO;
import org.progingo.dao.UserDao;
import org.progingo.domain.user.*;
import org.progingo.infrastructure.repository.UserAdapter;
import org.progingo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserApp {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAdapter userAdapter;

    public ActionResult signUser(User signUser){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(signUser.getPhone());
        User user = userDao.selectByExample(userExample).stream().findFirst().orElse(null);

        if (user != null){
            return ActionResult.fail(ResultCode.PHONE_EXIST);
        }
        signUser.setUsername(UUID.randomUUID().toString());
        signUser.setProfilePhoto("/eduhub/profile_photo.png");
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

        UserBO userBO = userAdapter.toBO(user);
        String token = tokenUtil.saveUserCache(userBO);
        return ActionResult.ok(token);
    }


    public ActionResult updateUser(User user) {
        userRepository.updateUser(user);
        tokenUtil.deleteIdToken(user.getId());
        return ActionResult.ok();
    }

    public List<UserBO> getUserInfoByNickName(String nickName) {
        return userRepository.findUserByNickName(nickName);
    }

    public UserBO getUserInfoByUsername(String username){
        if(username == null){
            return null;
        }
        return userRepository.findUserByUsername(username);
    }
}
