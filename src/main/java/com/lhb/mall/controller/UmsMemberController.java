package com.lhb.mall.controller;

import com.lhb.mall.common.api.CommonResult;
import com.lhb.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhb
 * @date 2022/1/16 21:28
 */
@RestController
@RequestMapping("member")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @GetMapping("captcha")
    public CommonResult generateCaptcha(@RequestParam String mobile) {
        String captcha = memberService.generateCaptcha(mobile);
        return CommonResult.success(captcha,"获取验证码成功");
    }

    @GetMapping("verifyCaptcha")
    public CommonResult verifyCaptcha(@RequestParam String mobile, @RequestParam String code) {
        if (memberService.verifyAuthCode(mobile, code)) {
            return CommonResult.success(null,"验证成功");
        } else {
            return CommonResult.failed("验证失败");
        }
    }
}
