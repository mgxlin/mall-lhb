package com.lhb.mall.service;

/**
 * @author lhb
 * @date 2022/1/16 20:20
 */
public interface UmsMemberService {
    /**
     * 获取验证码
     */
    String generateCaptcha(String mobile);

    /**
     * 校验验证码
     */
    boolean verifyAuthCode(String mobile, String code);
}
