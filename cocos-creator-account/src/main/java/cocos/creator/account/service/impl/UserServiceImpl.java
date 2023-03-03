package cocos.creator.account.service.impl;

import cocos.creator.account.entity.User;
import cocos.creator.account.mapper.UserMapper;
import cocos.creator.account.service.TokenCacheService;
import cocos.creator.account.service.UserService;
import cocos.creator.common.constant.FieldConstant;
import cocos.creator.common.enums.ResultCodeEnum;
import cocos.creator.common.util.ResultUtil;
import cocos.creator.common.util.TokenUtil;
import cocos.creator.common.vo.UserLoginVo;
import cocos.creator.common.vo.UserRegisterVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户服务实现类
 * </p>
 *
 * @author 刘旭辉
 * @since 2023-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private TokenCacheService tokenCacheService;

    @Override
    public ResultUtil getList() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<User> users = this.baseMapper.selectList(lambdaQueryWrapper);
        return ResultUtil.success(users);
    }

    @Override
    public ResultUtil deleteByUserId(String userId) {
        boolean update = new LambdaUpdateChainWrapper<>(this.baseMapper)
                .set(User::getIsDeleted, FieldConstant.IS_DELETED)
                .eq(User::getId, userId)
                .update();
        if (!update) {
            ResultUtil.error();
        }
        return ResultUtil.success();
    }

    @Override
    public ResultUtil deleteByMobile(String mobile) {
        boolean update = new LambdaUpdateChainWrapper<>(this.baseMapper)
                .set(User::getIsDeleted, FieldConstant.IS_DELETED)
                .eq(User::getMobile, mobile)
                .update();
        if (!update) {
            ResultUtil.error();
        }
        return ResultUtil.success();
    }

    @Override
    public ResultUtil register(UserRegisterVo userRegisterVo) {
        //参数校验
        if (userRegisterVo == null
                || StringUtils.isEmpty(userRegisterVo.getName())
                || StringUtils.isEmpty(userRegisterVo.getPassword())) {
            return ResultUtil.custom(ResultCodeEnum.ERROR_PARAM);
        }
        //校验用户名长度(0,20]
        if (userRegisterVo.getName().length() > 20) {
            return ResultUtil.custom(ResultCodeEnum.ERROR_NAME_LENGTH_LIMIT);
        }
        //校验用户名是否已存在
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, userRegisterVo.getName());
        Long count = this.baseMapper.selectCount(lambdaQueryWrapper);
        if (count != null && count > 0) {
            return ResultUtil.custom(ResultCodeEnum.ERROR_NAME_EXIST);
        }
        //新增
        int insert = this.baseMapper.insert(new User(userRegisterVo));
        if (insert > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public ResultUtil login(UserLoginVo userLoginVo) {
        //参数校验
        if (userLoginVo == null
                || StringUtils.isEmpty(userLoginVo.getName())
                || StringUtils.isEmpty(userLoginVo.getPassword())) {
            return ResultUtil.custom(ResultCodeEnum.ERROR_PARAM);
        }
        //根据name获取用户
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, userLoginVo.getName());
        User loginUser = this.baseMapper.selectOne(lambdaQueryWrapper);
        if (loginUser == null) {
            return ResultUtil.custom(ResultCodeEnum.ERROR_NAME_PASSWORD_LOGIN_FAIL);
        }
        //校验密码
        if (!userLoginVo.getPassword().equals(loginUser.getPassword())) {
            return ResultUtil.custom(ResultCodeEnum.ERROR_NAME_PASSWORD_LOGIN_FAIL);
        }
        //校验成功,生成token
        String token = TokenUtil.generatorToken(loginUser.getId());
        //token入redis缓存
        tokenCacheService.storeUserTokenCache(loginUser.getId(), token);
        return ResultUtil.success(token);
    }
}
