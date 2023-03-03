package cocos.creator.account.service;

import cocos.creator.account.entity.User;
import cocos.creator.common.util.ResultUtil;
import cocos.creator.common.vo.UserLoginVo;
import cocos.creator.common.vo.UserRegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 刘旭辉
 * @since 2023-03-01
 */
public interface UserService extends IService<User> {

    /**
     * 用户列表
     *
     * @return
     */
    ResultUtil getList();

    /**
     * 删除用户_userId
     *
     * @param userId
     * @return
     */
    ResultUtil deleteByUserId(String userId);

    /**
     * 删除用户_mobile
     *
     * @param mobile
     * @return
     */
    ResultUtil deleteByMobile(String mobile);

    /**
     * 用户注册
     *
     * @param userRegisterVo
     * @return
     */
    ResultUtil register(UserRegisterVo userRegisterVo);

    /**
     * 用户登录
     *
     * @param userLoginVo
     * @return
     */
    ResultUtil login(UserLoginVo userLoginVo);
}
