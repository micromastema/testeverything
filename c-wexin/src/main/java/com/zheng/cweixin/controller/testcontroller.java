package com.zheng.cweixin.controller;

import com.zheng.course.service.TestTransactionService;
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

    @RequestMapping("/test")
    public String testcontroller1(){
        String testservice = testTransactionService.testservice();
        String test = CoreUtil.test(1);
        System.out.println(testservice);
        return "asdf";
    }
}
