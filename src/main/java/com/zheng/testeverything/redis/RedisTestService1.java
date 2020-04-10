package com.zheng.testeverything.redis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@Component
public class RedisTestService1 {

    @Cacheable(value = "guavaDemo", key = "#id")
    public String testc(String id) {
        return "test";
    }
}
