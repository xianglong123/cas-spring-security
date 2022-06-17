package com.cas.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午3:07 2021/4/11
 * @version: V1.0
 * @review:
 */
// @Service
public class MyDataUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username= " + username);
        // todo 这里后面改成用DB查
        UserDetails user = User.withUsername(username).password("$2a$10$ZGEzglEemyme6zWSIjDMOO7qqZ3GB3dC9LXZYjBCfhCzcn5HJaLuW").authorities("p1").build();
        return user;
    }

}
