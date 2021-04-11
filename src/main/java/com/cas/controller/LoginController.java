package com.cas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午1:44 2021/4/11
 * @version: V1.0
 * @review:
 */
@RestController
public class LoginController {


    @RequestMapping("/login-success")
    public String loginSuccess() {
        return "登录成功";
    }

    @GetMapping("/r/r1")
    public String r1() {
        return "访问资源1";
    }

    @GetMapping("/r/r2")
    public String r2() {
        return "访问资源2";
    }




}
