package com.zheng.testeverything;

import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengchentong
 */
@SpringBootApplication(exclude = SpringBootConfiguration.class)
public class TesteverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteverythingApplication.class, args);
    }

}
