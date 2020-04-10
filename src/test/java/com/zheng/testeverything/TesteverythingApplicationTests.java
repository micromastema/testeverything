package com.zheng.testeverything;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.channels.FileChannel;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class TesteverythingApplicationTests {

    @Test
    public void contextLoads() {

//        String s1 = "hello";
//        String s2 = "hello";
//        String s3 = "he" + "llo";
//        String s4 = "hel" + new String("lo");
//        String s5 = new String("hello");
//        String s6 = s5.intern();
//        String s7 = "h";
//        String s8 = "ello";
//        String s9 = s7 + s8;
//        System.out.println(s1==s2);//true
//        System.out.println(s1==s3);//true
//        System.out.println(s1==s4);//false
//        System.out.println(s1==s9);//false
//        System.out.println(s4==s5);//false
//        System.out.println(s1==s6);//true


        String s1 = new String("hello");
        String intern1 = s1.intern();
        String s2 = "hello";
        System.out.println(s1 == s2);
        String s3 = new String("hello") + new String("hello");
        String intern3 = s3.intern();
        String s4 = "hellohello";
        System.out.println(s3 == s4);

    }



}
