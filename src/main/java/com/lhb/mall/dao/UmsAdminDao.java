package com.lhb.mall.dao;

import com.lhb.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lhb
 * @date 2022/1/17 13:23
 */
public interface UmsAdminDao {

    /**
     * 获取用户所有权限
     */
    List<UmsPermission> getPermissions(@Param("adminId") Long adminId);
}
