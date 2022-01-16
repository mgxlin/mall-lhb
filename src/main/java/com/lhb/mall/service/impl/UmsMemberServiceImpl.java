package com.lhb.mall.service.impl;

import com.lhb.mall.service.RedisService;
import com.lhb.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @author lhb
 * @date 2022/1/16 20:25
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long REDIS_KEY_EXPIRE_CODE;

    @Override
    public String generateCaptcha(String mobile) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int nextInt = random.nextInt(10);
            builder.append(nextInt);
        }
        String code = builder.toString();
        redisService.set(REDIS_KEY_PREFIX_CODE + mobile, code);
        redisService.expire(REDIS_KEY_PREFIX_CODE + mobile, REDIS_KEY_EXPIRE_CODE);
        return code;
    }

    @Override
    public boolean verifyAuthCode(String mobile, String code) {
        if (StringUtils.isEmpty(code)){
            return false;
        }
        String authCode = redisService.get(REDIS_KEY_PREFIX_CODE + mobile);
        return code.equals(authCode);
    }
}
