package com.zheng.testeverything.controller;

import com.zheng.testeverything.service.DataService;
import com.zheng.testeverything.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private DataService dataService;
    @Autowired
    private InsertService insertService;

    @GetMapping("/t")
    public void test() {
//        dataService.deala();
//        dataService.dealb();
//        dataService.dealc();
//        dataService.deald1();
//        dataService.deald2();

        insertService.deala();
        insertService.dealc();
        insertService.deald1();
        insertService.deald2();
        insertService.deald4();
        insertService.deald5();
        insertService.deald6();
        insertService.deald7();
        insertService.deald8();
        insertService.deald9();
        System.out.println("");

    }
}
