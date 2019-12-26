package com.zheng.cweixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhengchentong
 */
@SpringBootApplication(scanBasePackages = "com.zheng")
@MapperScan({"com.zheng.course","com.zheng.customer"})
public class TesteverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteverythingApplication.class, args);
    }

}
