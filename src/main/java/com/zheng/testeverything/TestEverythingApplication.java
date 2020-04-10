package com.zheng.testeverything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zhengchentong
 */
@SpringBootApplication
@EnableCaching
public class TestEverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestEverythingApplication.class, args);
    }

}
