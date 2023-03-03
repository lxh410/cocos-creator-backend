package cocos.creator.common.enums;

import lombok.Getter;

/**
 * redis存储的key枚举
 *
 * @author 刘旭辉
 */
@Getter
public enum RedisKeyEnum {

    TOKEN_USER("TOKEN_USER", "用户token"),
    USER_TOKEN_LIST("USER_TOKEN_LIST", "用户token列表集合");

    private final String code;
    private final String message;

    RedisKeyEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
