package cocos.creator.common.enums;

import lombok.Getter;

/**
 * 返回枚举
 *
 * @author 刘旭辉
 */
@Getter
public enum ResultCodeEnum {
    /*通用*/
    SUCCESS(200, "操作成功"),
    ERROR(500, "操作失败"),

    /*通用2*/
    ERROR_PARAM(600, "参数有误"),

    /*用户: [10001~10100]*/
    ERROR_MOBILE_PARAM_CHECK(10001, "手机号有误,请重新输入"),
    ERROR_MOBILE_EXIST(10002, "手机号已存在,请重新输入"),
    ERROR_NAME_EXIST(10003, "该名称已存在,请重新输入"),
    ERROR_NAME_LENGTH_LIMIT(10004, "名称长度请保持在20以内"),
    ERROR_NAME_PASSWORD_LOGIN_FAIL(10005, "名称或密码有误,请重新输入");

    private final int code;
    private final String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
