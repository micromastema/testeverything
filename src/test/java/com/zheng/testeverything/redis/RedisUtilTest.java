package com.zheng.testeverything.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
public class RedisUtilTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTestService redisTestService;

    @Test
    public void test() {
        redisService.set("a", "a");
        String a = redisService.get("a");
        System.out.println(a);
    }

    @Test
    public void testc() {
        redisTestService.testa();
    }

}
