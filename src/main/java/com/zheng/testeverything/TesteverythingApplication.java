package com.zheng.testeverything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhengchentong
 */
@SpringBootApplication
@EnableTransactionManagement
public class TesteverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteverythingApplication.class, args);
    }

}
