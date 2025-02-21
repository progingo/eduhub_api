package org.progingo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionResult {
    private ResultCode resultCode;
    private String msg;

    public static ActionResult ok() {
        return new ActionResult(ResultCode.SUCCESS, "");
    }
    public static ActionResult ok(String msg) {
        return new ActionResult(ResultCode.SUCCESS, msg);
    }
    public static ActionResult fail(String msg) {
        return new ActionResult(ResultCode.FAIL, msg);
    }
    public static ActionResult fail(ResultCode resultCode, String msg) {
        return new ActionResult(resultCode, msg);
    }
    public static ActionResult fail(ResultCode resultCode) {
        return new ActionResult(resultCode, resultCode.getMsg());
    }

    public boolean isSuccess() {
        return resultCode == ResultCode.SUCCESS;
    }


}
