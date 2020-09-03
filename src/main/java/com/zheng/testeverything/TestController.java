package com.zheng.testeverything;

import com.zheng.testeverything.mapper.LogMapper;
import com.zheng.testeverything.model.Log;
import com.zheng.testeverything.service.LogService;
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
    private LogMapper logMapper;
    @Autowired
    private LogService logService;

    @GetMapping("/t")
    public void test(){
        Log byId = logMapper.findById(1L);

        System.out.println("");

    }
}
