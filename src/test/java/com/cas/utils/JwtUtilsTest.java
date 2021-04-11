package com.cas.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午7:53 2021/4/7
 * @version: V1.0
 * @review:
 */
class JwtUtilsTest {

    @Test
    void createToken() {
        String token = JwtUtils.createToken("xianglong");
        System.out.println(token);
    }

    @Test
    void getTokenClaim() {
        String token = JwtUtils.createToken("xianglong");
        Claims tokenClaim = JwtUtils.getTokenClaim(token);
        assert tokenClaim != null;
        System.out.println(tokenClaim.getSubject());
    }

    @Test
    void isTokenExpired() {
        String[] split = "midcloud:111:333".split(":", 2);
        System.out.println(split);

    }

    @Test
    void getExpirationDateFromToken() {
    }

    @Test
    void getUsernameFromToken() {
    }

    @Test
    void getIssuedAtDateFromToken() {
    }
}
