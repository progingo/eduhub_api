package org.progingo.infrastructure.user;

import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {

    public ActionResult checkSignUser(User user){
        if (user.getNickname() == null || user.getNickname().isEmpty() || user.getNickname().length() > 10){
            return ActionResult.fail(ResultCode.NAME_INVA);
        }

        if (user.getPassword() == null || user.getPassword().length() < 6 || user.getPassword().length() > 20){
            return ActionResult.fail(ResultCode.PASSWORD_INVA);
        }
        String phoneRegex = "^1[3-9]\\d{9}$";
        if (user.getPhone() == null || !user.getPhone().matches(phoneRegex)){
            return ActionResult.fail(ResultCode.PHONE_INVA);
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (user.getEmail() != null && !user.getEmail().matches(emailRegex)){
            return ActionResult.fail(ResultCode.EMAIL_INVA);
        }
        return ActionResult.ok();
    }


    public ActionResult checkLoginUser(User user){

        String phoneRegex = "^1[3-9]\\d{9}$";
        if (user.getPhone() == null || !user.getPhone().matches(phoneRegex)){
            return ActionResult.fail(ResultCode.PHONE_INVA);
        }

        if (user.getPassword() == null || user.getPassword().length() < 6 || user.getPassword().length() > 20){
            return ActionResult.fail(ResultCode.PASSWORD_INVA);
        }

        return ActionResult.ok();
    }

    public ActionResult checkUpdateBaseInfoUser(User user) {
        if (user.getNickname() == null || user.getNickname().isEmpty() || user.getNickname().length() > 10){
            return ActionResult.fail(ResultCode.NAME_INVA);
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (user.getEmail() != null && !user.getEmail().matches(emailRegex)){
            return ActionResult.fail(ResultCode.EMAIL_INVA);
        }
        return ActionResult.ok();
    }
}
