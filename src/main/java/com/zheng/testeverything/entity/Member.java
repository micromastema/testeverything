package com.zheng.testeverything.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

/**
 * @author zhengchentong on 2019/12/23
 */
@Setter
@Getter
public class Member {
    private String _id;
    private String openid;
    private LinkedHashMap<Object,Object> learnTrace;
}
