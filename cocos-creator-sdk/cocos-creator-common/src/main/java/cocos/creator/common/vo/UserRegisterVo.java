package cocos.creator.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户注册视图
 *
 * @author 刘旭辉
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterVo {

    private String name;

    private String password;

}
