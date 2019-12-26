package com.zheng.testeverything.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author zhengchentong on 2019-06-15
 */
@Service
public class TestTransactionService {


    public void test(){
        List<String> a = new ArrayList<>();

        SortedMap<String, String> aa = new TreeMap<>();
        SortedMap<String, String> a1a;
        ConcurrentSkipListMap<String, String> ab = new ConcurrentSkipListMap<>();
    }
}
