package com.zheng.testeverything.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/test1")
    public String test() {
        int a = 1;
        int b = 0;
        int c = a / b;
        return "ok";
    }
}
