package cocos.creator.common.enums.user;

import lombok.Getter;

/**
 * 用户状态枚举
 *
 * @author 刘旭辉
 */
@Getter
public enum UserStatusEnum {

    NORMAL(0, "正常"),
    BAN(1, "被禁用");

    private final Integer code;
    private final String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
