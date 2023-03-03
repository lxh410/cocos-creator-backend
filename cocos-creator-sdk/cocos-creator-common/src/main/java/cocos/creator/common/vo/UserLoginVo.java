package cocos.creator.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录视图
 *
 * @author 刘旭辉
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVo {

    private String name;

    private String password;
}
