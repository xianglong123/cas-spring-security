package com.cas.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午3:31 2021/4/11
 * @version: V1.0
 * @review:
 */
public class BCryptTest {

    @Test
    public void testBCrypt() {
        // 对密码进行加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);
        //$2a$10$XIDNheiznIqXpD9tUpA3deD1G6dPqeZMSkzPfJFJOYNbC69o7f2g6
        //$2a$10$XyJwZvzrGK4N69.iXyO3JOxB45p1B/wU1wPIPwl.r..Qfk2o4aD.u

        // 校验密码
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$XyJwZvzrGK4N69.iXyO3JOxB45p1B/wU1wPIPwl.r..Qfk2o4aD.u");
        boolean checkpw2 = BCrypt.checkpw("123", "$2a$10$XIDNheiznIqXpD9tUpA3deD1G6dPqeZMSkzPfJFJOYNbC69o7f2g6");

        System.out.println("校验结果1：" + checkpw);
        System.out.println("校验结果2：" + checkpw2);
    }


}
