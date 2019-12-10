package com.zheng.testeverything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhengchentong
 */
@SpringBootApplication
@EnableSwagger2
public class TesteverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteverythingApplication.class, args);
    }

}
