package cocos.creator.account.service;

/**
 * <p>
 * token缓存服务类
 * </p>
 *
 * @author 刘旭辉
 * @since 2023-03-01
 */
public interface TokenCacheService {

    /**
     * 存入用户token至缓存
     *
     * @param userId
     * @param token
     */
    void storeUserTokenCache(String userId, String token);
}
