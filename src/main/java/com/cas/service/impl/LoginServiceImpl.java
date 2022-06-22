package com.cas.service.impl;

import com.cas.bean.UserRequest;
import com.cas.domain.LoginUser;
import com.cas.domain.ResponseResult;
import com.cas.service.LoginService;
import com.cas.utils.JwtUtils;
import com.cas.utils.RedisUtil;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/20 12:18 下午
 * @desc
 */
@Service
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public ResponseResult login(UserRequest request) {
        // AuthenticationManager authenticate进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        // 如果认证通过了，使用userId生成一个jwt, jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getSysUser().getId().toString();
        String jwt = JwtUtils.createToken(userId);
        // 把完整的用户信息存入redis userid作为key
        redisUtil.set("login:" + userId, loginUser);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return new ResponseResult("200", "登录成功", map);
    }
}
