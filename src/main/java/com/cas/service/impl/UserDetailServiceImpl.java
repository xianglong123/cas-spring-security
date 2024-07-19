package com.cas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cas.bean.SysUser;
import com.cas.dao.MenuMapper;
import com.cas.dao.UserMapper;
import com.cas.domain.LoginUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午3:07 2021/4/11
 * @version: V1.0
 * @review:
 */
 @Service
public class UserDetailServiceImpl implements UserDetailsService {

     @Resource
     private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUserName, username);
        SysUser user = userMapper.selectOne(queryWrapper);
        // 如果没有查询到用户就抛出异常
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }

        // todo 查询对应的权限信息
//        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        List<String> list = Arrays.asList("a", "b");
        // 把数据封装成UserDetail返回
        return new LoginUser(user, list);
    }

}
