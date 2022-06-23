package com.cas.service;

import com.cas.bean.UserRequest;
import com.cas.domain.ResponseResult;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/20 12:18 下午
 * @desc
 */
public interface LoginService {

    ResponseResult login(UserRequest request);

    ResponseResult logout();
}
