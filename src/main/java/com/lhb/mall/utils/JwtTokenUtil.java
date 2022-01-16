package com.lhb.mall.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lhb
 * @date 2022/1/16 21:54
 */
@Component
public class JwtTokenUtil {
    @Value("jwt.secret")
    private String secret;
    @Value("jwt.expiration")
    private Long expiration;

    public static final String CLAIM_KEY_USERNAME = "sub";
    public static final String CLAIM_KEY_CREATED = "created";

    /**
     * 根据负载生成jwt的token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(generateExpirationDate())
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
    }

    /**
     * 创建过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从token中获取jwt中的负载
     */
    private Claims getClaimsFromToken(String token) {

        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 从token中获取用户名
     */
    public String getUserNameFromToken(String token) {
        String username = null;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

    /**
     * 验证token是否有效
     */
    public boolean verifyToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return  (username.equals(userDetails.getUsername()) && !isExpiredToken(token));
    }

    /**
     * 验证token是否过期
     * @return
     */
    private boolean isExpiredToken(String token) {
        Date date = getExpirationDate(token);
        return date.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpirationDate(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 根据用户信息生成token
     */
    public String generationToken(UserDetails userDetails) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        map.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(map);
    }

    /**
     * 判断token是否可以刷新
     */
    public boolean canRefresh(String token) {
        return !isExpiredToken(token);
    }

    /**
     * 刷新token
     */
    public String refresh(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

}
