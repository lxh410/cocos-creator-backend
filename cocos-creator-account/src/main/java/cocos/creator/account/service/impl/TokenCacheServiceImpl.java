package cocos.creator.account.service.impl;

import cocos.creator.account.service.TokenCacheService;
import cocos.creator.common.constant.DateConstant;
import cocos.creator.common.constant.StringConstant;
import cocos.creator.common.constant.TokenConstant;
import cocos.creator.common.enums.RedisKeyEnum;
import cocos.creator.common.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * token缓存服务实现类
 * </p>
 *
 * @author 刘旭辉
 * @since 2023-03-01
 */
@Service
public class TokenCacheServiceImpl implements TokenCacheService {


    @Resource
    private RedisUtil redisUtil;

    @Override
    public void storeUserTokenCache(String userId, String token) {
        //存储token
        redisUtil.set(getUserTokenKey(token), userId, TokenConstant.EXPIRE_S);
        //记录userId管理token列表
        redisUtil.set(getUserTokenListKey(userId, token), new SimpleDateFormat(DateConstant.DATE_FORMAT).format(new Date()), TokenConstant.EXPIRE_S);
    }

    /**
     * 生成用户token存储的key
     *
     * @param token
     * @return
     */
    private String getUserTokenKey(String token) {
        return RedisKeyEnum.TOKEN_USER.getCode().concat(StringConstant.REDIS_SPLIT).concat(token);
    }

    /**
     * 生成用户token存储的key
     *
     * @param userId
     * @param token
     * @return
     */
    private String getUserTokenListKey(String userId, String token) {
        return RedisKeyEnum.USER_TOKEN_LIST.getCode().concat(StringConstant.REDIS_SPLIT).concat(userId).concat(StringConstant.REDIS_SPLIT).concat(token);
    }

}
