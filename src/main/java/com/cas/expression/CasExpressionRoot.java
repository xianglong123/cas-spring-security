package com.cas.expression;

import com.cas.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/23 4:01 下午
 * @desc SPEL表达式
 */
@Component("cas")
public class CasExpressionRoot {

    public boolean hasAuthority(String authority) {
        // 获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        // 判断用户权限集合是否存在authority
        return permissions.contains(authority);
    }

}
