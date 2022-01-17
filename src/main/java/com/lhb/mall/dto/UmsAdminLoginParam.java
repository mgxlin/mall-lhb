package com.lhb.mall.dto;

import javax.validation.constraints.NotNull;

/**
 * @author lhb
 * @date 2022/1/17 13:09
 */
public class UmsAdminLoginParam {
    @NotNull(message = "用户名不可为空")
    private String username;
    @NotNull(message = "密码不可为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
