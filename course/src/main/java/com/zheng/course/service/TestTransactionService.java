package com.zheng.course.service;

import com.zheng.course.model1.TestMapper1;
//import com.zheng.course.model2.TestMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengchentong on 2019-06-15
 */
@Service
public class TestTransactionService {

    public String testservice(){
        return "a";
    }


    @Autowired
    TestMapper1 testMapper1;
//    @Autowired
//    TestMapper2 testMapper2;
    public String testservice2(){
        String getid = testMapper1.getid("1");

//        String getid1 = testMapper2.getid("2");
//        return getid+","+getid1;
        return getid;
    }
}
