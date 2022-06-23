package com.cas.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSONObject;
import com.cas.domain.ResponseResult;
import com.cas.utils.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/23 2:36 下午
 * @desc 认证失败会调用到这里
 * 分认证失败，和授权失败
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(String.valueOf(HttpStatus.HTTP_UNAUTHORIZED), "认证失败，请重新登录");
        String json = JSONObject.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
