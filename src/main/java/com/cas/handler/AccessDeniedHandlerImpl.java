package com.cas.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSONObject;
import com.cas.domain.ResponseResult;
import com.cas.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/23 2:47 下午
 * @desc 授权失败会调到这
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(String.valueOf(HttpStatus.HTTP_FORBIDDEN), "您的权限不足");
        String json = JSONObject.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
