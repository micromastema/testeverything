package com.zheng.testeverything.rocketmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
public class ProduceTest {
    @Autowired
    private Produce produce;

    @Test
    public void test() {
        produce.run();
    }

    @Test
    public void test2() {
        System.out.println(new Date());
        produce.sendDelayMessage();
    }

}
