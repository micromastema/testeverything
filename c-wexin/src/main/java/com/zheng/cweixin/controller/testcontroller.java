package com.zheng.cweixin.controller;

import com.zheng.course.service.TestTransactionService;
import com.zheng.customer.service.TestTransactionService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.CoreUtil;

/**
 * @author zhengchentong on 2019/12/26
 */
@RestController
@RequestMapping("")
public class testcontroller {

    @Autowired
    private TestTransactionService testTransactionService;

    @Autowired
    private TestTransactionService2 testTransactionService2;

    @RequestMapping("/test")
    public String testcontroller1(){
        String testservice = testTransactionService.testservice();
        String test = CoreUtil.test(1);
        System.out.println(testservice);

        String s = testTransactionService.testservice2();
        System.out.println(s);

        String s1 = testTransactionService2.testservice2();
        System.out.println(s1);

        return "asdf";
    }
}
