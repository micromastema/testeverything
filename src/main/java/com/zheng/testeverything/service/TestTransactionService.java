package com.zheng.testeverything.service;

//import com.zheng.testeverything.model1.TestDao1;
//import com.zheng.testeverything.model1.TestMapper1;

import com.zheng.testeverything.model2.TestDao2;
import com.zheng.testeverything.model2.TestMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengchentong on 2019-06-15
 */
@Service
public class TestTransactionService {

    //    @Autowired
//    private TestMapper1 testMapper1;
//
    @Autowired
    private TestMapper2 testMapper2;

//    @Autowired
//    private TestDao1 testDao1;

    @Autowired
    private TestDao2 testDao2;

    public String getid() {
        String a = testMapper2.getid(1);
        String b = testMapper2.getid(2);
        return "ok";
    }

    public void insert() throws Exception {
//        testDao1.insert1();
        testDao2.insert1();
    }
}
