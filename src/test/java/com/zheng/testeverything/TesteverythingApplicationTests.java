package com.zheng.testeverything;

import com.zheng.testeverything.model1.TestMapper1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class TesteverythingApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("a");
    }

    @Autowired
    private TestMapper1 testMapper;

    @Test
    public void test1(){
        testMapper.getid("10");
    }

    @Test
    public void test2(){
        int a= 0;
        while(true){
            a=a+1;
            System.out.println(a);
            String b = a+1+"";
            String c = a+2+"";
            String d = a+3+"";
            String e = a+4+"";
            String f = a+5+"";
            String g = a+6+"";
            testMapper.insert(String.valueOf(a),b,c,d,e,f,g);
        }
    }

    @Test
    public void test3(){
        Random random = new Random();
        LocalDateTime now = LocalDateTime.now();
        for(int i =0;i<1000;i++){
            int a = random.nextInt(50000);
            String getid = testMapper.getid(Integer.toString(a));
//            System.out.println(i);
        }
        LocalDateTime now1 = LocalDateTime.now();

        Duration between = Duration.between(now, now1);
        long l = between.toMillis();
        System.out.println(l);
        //20 13.4
        //40 13.2
        //100 13.6
        //200 13.4
        //300 13.5
        //400 13.7
        //500 13.6
        //600 13.7
    }
}
