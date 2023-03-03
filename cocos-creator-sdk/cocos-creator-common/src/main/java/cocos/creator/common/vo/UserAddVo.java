package cocos.creator.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 添加用户视图
 *
 * @author 刘旭辉
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddVo {

    private String name;

    private String mobile;

    private Integer sex;

    private String head;
}
