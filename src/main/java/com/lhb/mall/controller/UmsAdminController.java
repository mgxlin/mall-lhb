package com.lhb.mall.controller;

import com.lhb.mall.common.api.CommonResult;
import com.lhb.mall.dto.UmsAdminLoginParam;
import com.lhb.mall.mbg.model.UmsAdmin;
import com.lhb.mall.mbg.model.UmsPermission;
import com.lhb.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author lhb
 * @date 2022/1/17 13:03
 */
@RestController
@RequestMapping("admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @PostMapping("register")
    public CommonResult register(@RequestBody UmsAdmin umsAdmin) {
        UmsAdmin admin = adminService.register(umsAdmin);
        if (admin != null) {
            return CommonResult.success(admin,"注册成功");
        }
        return CommonResult.failed("注册失败，用户已存在");
    }

    @PostMapping("login")
    public CommonResult login(@RequestBody UmsAdminLoginParam loginParam) {
        //调用登录方法获取token
        String token = adminService.login(loginParam.getUsername(), loginParam.getPassword());
        //token为空说明 用户名或密码错误
        if (StringUtils.isEmpty(token)) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        HashMap<String, String> map = new HashMap<>();
        //把 token、tokenHead 返回给前端
        map.put("token", token);
        map.put("tokenHead", tokenHead);
        return CommonResult.success(map);
    }

    @GetMapping("permissions/{id}")
    public CommonResult getPermissions(@PathVariable("id") Long id) {
        List<UmsPermission> permissions = adminService.getPermissions(id);
        return CommonResult.success(permissions);
    }
}
