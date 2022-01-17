package com.lhb.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.lhb.mall.mbg.mapper.UmsAdminMapper;
import com.lhb.mall.mbg.model.UmsAdmin;
import com.lhb.mall.mbg.model.UmsAdminExample;
import com.lhb.mall.mbg.model.UmsPermission;
import com.lhb.mall.service.UmsAdminService;
import com.lhb.mall.service.UmsMemberService;
import com.lhb.mall.utils.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lhb
 * @date 2022/1/17 12:27
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UmsAdmin getAdminByUser(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> list = adminMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        //先通过用户名查询用户
        UmsAdmin admin = getAdminByUser(umsAdmin.getUsername());
        //用户已存在则直接返回
        if (admin != null) {
            return null;
        }
        //新建用户
        UmsAdmin user = new UmsAdmin();
        //将填写的信息赋值给新用户
        BeanUtils.copyProperties(umsAdmin, user);
        user.setStatus(1);
        user.setCreateTime(new Date());
        //对填写的密码进行编码
        String encode = passwordEncoder.encode(umsAdmin.getPassword());
        //将新密码赋值给新建用户
        user.setPassword(encode);
        adminMapper.insertSelective(user);
        return user;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            //通过用户名获取 用户信息 UserDetails
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //比较填写的密码 跟 用户信息中的密码
            if (!passwordEncoder.matches(password,userDetails.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generationToken(userDetails);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        } catch (BadCredentialsException e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public List<UmsPermission> getPermissions(Long id) {
        return null;
    }
}
