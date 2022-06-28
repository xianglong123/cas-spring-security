package com.cas.controller;

import com.cas.bean.UserRequest;
import com.cas.domain.ResponseResult;
import com.cas.service.LoginService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午1:44 2021/4/11
 * @version: V1.0
 * @review:
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(UserRequest request) {
        return loginService.login(request);
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }

    @GetMapping("/r/r1")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public String r1() {
        return "访问资源1" + getUsername();
    }

    /**
     * SPEL表达式使用@cas获取容器中bean为cas的对象
     * @return
     */
    @GetMapping("/r/r3")
    @PreAuthorize("@cas.hasAuthority('system:dept:list')")
    public String r3() {
        return "访问资源1" + getUsername();
    }


    @GetMapping("/r/r2")
    @PreAuthorize("hasAuthority('p2')")
    public String r2() {
        return "访问资源2" + getUsername();
    }

    private String getUsername() {
        String username = null;
        // 当前认证 通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "匿名";
        }
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }


}
