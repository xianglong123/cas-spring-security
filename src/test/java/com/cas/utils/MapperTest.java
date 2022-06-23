package com.cas.utils;

import com.cas.dao.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/23 11:37 上午
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Resource
    private MenuMapper menuMapper;

    @Test
    public void test() {
        List<String> list = menuMapper.selectPermsByUserId(1L);
        System.out.println(list);
    }

}
