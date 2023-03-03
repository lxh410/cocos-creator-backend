package cocos.creator.account.entity;

import cocos.creator.common.enums.user.UserStatusEnum;
import cocos.creator.common.vo.UserRegisterVo;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author 刘旭辉
 * @since 2023-03-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@ApiModel(value = "User对象", description = "用户")
public class User implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId("id")
    private String id;

    @ApiModelProperty("用户名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("性别: 0男,1女")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("用户头像url")
    @TableField("head")
    private String head;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("用户状态: 0正常,1被禁用")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("删除状态: 0未删除,1已删除")
    @TableField(value = "isDeleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty("创建人")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改人")
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    public User(UserRegisterVo userRegisterVo) {
        this.name = userRegisterVo.getName();
        this.password = userRegisterVo.getPassword();
        this.status = UserStatusEnum.NORMAL.getCode();
    }


}
