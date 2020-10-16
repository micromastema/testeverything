package com.zheng.testeverything.controller;

import com.zheng.testeverything.service.DataService;
import com.zheng.testeverything.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
//        dataService.dealb3();
//        dataService.dealc();

//        insertService.deala();
//        insertService.dealb3();
//        insertService.dealc();
        System.out.println("");

        dataService.deale1();
        System.out.println("");
    }

    @GetMapping("/t1")
    public void test1() {
        List<Map<String, String>> maps = dataService.dealb3();
        for (Map<String, String> stringStringMap : maps) {
            String num = stringStringMap.get("num");
            String name = stringStringMap.get("name");
            if (name.contains("\t")) {
                System.out.println("");
            }
        }

    }
}
