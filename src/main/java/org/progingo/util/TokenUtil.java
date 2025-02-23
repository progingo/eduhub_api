package org.progingo.util;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson2.JSON;
import org.progingo.domain.user.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class TokenUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //通过token获取用户信息
    public UserBO getUserCache(String token) {
        String userJson = stringRedisTemplate.opsForValue().get(RedisPrefix.USER_LOGIN_TOKEN + token);
        if (userJson == null)
            return null;

        return JSON.parseObject(userJson, UserBO.class);
    }

    //保存用户信息到缓存并返回token
    public String saveUserCache(UserBO user){

        //随机生成token，做为登录令牌
        String token = UUID.randomUUID().toString(true);
        //将UserBO转换成JSON
        String json = JSON.toJSONString(user);
        //保存到redis中
        stringRedisTemplate.opsForValue().set(RedisPrefix.USER_LOGIN_TOKEN + token, json);
        //设置有效期
        stringRedisTemplate.expire(RedisPrefix.USER_LOGIN_TOKEN + token, 3L, TimeUnit.DAYS);
        //返回token
        return token;
    }

    public void deleteUserCache(String token){
        stringRedisTemplate.delete(RedisPrefix.USER_LOGIN_TOKEN + token);
    }

    public void deleteIdToken(Integer id){
        Set<String> keys = stringRedisTemplate.keys(RedisPrefix.USER_LOGIN_TOKEN + "*");
        for (String key : keys) {
            String userJson = stringRedisTemplate.opsForValue().get(key);
            UserBO user = JSON.parseObject(userJson, UserBO.class);

            if (user != null && id.equals(user.getId()))
                stringRedisTemplate.delete(key);
        }
    }

}
