package cocos.creator.common.util;

import cn.hutool.core.util.IdUtil;
import cocos.creator.common.constant.TokenConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * token工具类
 *
 * @author 刘旭辉
 */
@Component
public class TokenUtil {
    /**
     * jwt生成token
     *
     * @param userId:用户id
     * @return
     */
    public static String generatorToken(String userId) {
        //生成一个随机数，避免token生成重复
        //jti(id): jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
        String token = Jwts.builder().setSubject(TokenConstant.SUBJECT)
                .claim("userId", userId)
                .setId(IdUtil.fastUUID())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TokenConstant.EXPIRE_MS))
                .signWith(SignatureAlgorithm.HS256, TokenConstant.SECRET).compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return userId
     */
    public static String parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(TokenConstant.SECRET).parseClaimsJws(token).getBody();
        if (claims == null) {
            return null;
        }
        return String.valueOf(claims.get("userId"));
    }

}
