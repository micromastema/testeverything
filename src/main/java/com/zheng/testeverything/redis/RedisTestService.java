package com.zheng.testeverything.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@Component
public class RedisTestService {

    @Autowired
    private RedisTestService1 redisTestService1;

    public void testa() {
        redisTestService1.testc("wwww");
    }

}
