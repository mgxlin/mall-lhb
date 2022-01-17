package com.lhb.mall.service;

import com.lhb.mall.mbg.model.UmsAdmin;
import com.lhb.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * @author lhb
 * @date 2022/1/17 12:23
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取用户
     */
    UmsAdmin getAdminByUser(String username);

    /**
     * 注册
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 登录
     */
    String login(String username, String password);

    /**
     * 获取用户所以权限
     */
    List<UmsPermission> getPermissions(Long id);
}
