package com.zheng.testeverything;

import com.zheng.testeverything.service.TestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestTransactionService testTransactionService;

    @RequestMapping("/test1")
    public String test1() {
        return testTransactionService.getid();
    }

    @RequestMapping("/test2")
    public String test2() throws Exception {
        testTransactionService.insert();
        return "ok";
    }

    @GetMapping("/test3")
    public String test3(){
        testTransactionService.test();
        return "";
    }
}
