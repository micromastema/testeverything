package com.zheng.testeverything;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/test2")
    public String test2() throws Exception {
        return "ok";
    }
}
