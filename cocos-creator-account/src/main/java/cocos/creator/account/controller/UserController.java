package cocos.creator.account.controller;

import cocos.creator.account.service.UserService;
import cocos.creator.common.util.ResultUtil;
import cocos.creator.common.vo.UserLoginVo;
import cocos.creator.common.vo.UserRegisterVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户模块接口
 * </p>
 *
 * @author 刘旭辉
 * @since 2023-03-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public ResultUtil list() {
        return userService.getList();
    }

    @ApiOperation("删除用户_userId")
    @DeleteMapping("/deleteByUserId/{userId}")
    public ResultUtil deleteByUserId(@PathVariable("userId") String userId) {
        return userService.deleteByUserId(userId);
    }

    @ApiOperation("删除用户_mobile")
    @DeleteMapping("/deleteByMobile/{mobile}")
    public ResultUtil deleteByMobile(@PathVariable("mobile") String mobile) {
        return userService.deleteByMobile(mobile);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultUtil login(@RequestBody UserLoginVo userLoginVo) {
        return userService.login(userLoginVo);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResultUtil register(@RequestBody UserRegisterVo userRegisterVo) {
        return userService.register(userRegisterVo);
    }


}
