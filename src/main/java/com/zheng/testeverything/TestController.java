package com.zheng.testeverything;

import com.zheng.testeverything.service.TestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengchentong on 2019/12/30
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    TestTransactionService testTransactionService;

    @RequestMapping("test")
    public String test(){
        testTransactionService.test();
        return "a";
    }
}
