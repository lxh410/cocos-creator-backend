package cocos.creator.generator.service.impl;

import cocos.creator.generator.entity.User;
import cocos.creator.generator.mapper.UserMapper;
import cocos.creator.generator.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘旭辉
 * @since 2023-03-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
