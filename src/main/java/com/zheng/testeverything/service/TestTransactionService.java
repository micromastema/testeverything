package com.zheng.testeverything.service;

import com.zheng.testeverything.model1.TestDao1;
import com.zheng.testeverything.model1.TestMapper1;
import com.zheng.testeverything.model2.TestDao2;
import com.zheng.testeverything.model2.TestMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author zhengchentong on 2019-06-15
 */
@Service
public class TestTransactionService {

    @Autowired
    private TestDao1 testDao1;

    @Autowired
    private TestDao2 testDao2;

    public String getid() {
        int i = 1;
        String a = testDao1.getid(String.valueOf(i));
        String b = testDao2.getid(String.valueOf(i));
        System.out.println(a);
        System.out.println(b);
        return "ok";
    }

    @Transactional
    public void insert() throws Exception {
        testDao1.insert1();
        testDao2.insert1();
    }
}
