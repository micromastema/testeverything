package com.zheng.cweixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhengchentong
 */
@SpringBootApplication(scanBasePackages = "com.zheng")
public class TesteverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteverythingApplication.class, args);
    }

}
