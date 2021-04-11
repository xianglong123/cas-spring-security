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
@Service
public class MyDataUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username= " + username);
        UserDetails user = User.withUsername("zhangsan").password("123").authorities("p1").build();
        return user;
    }

}
