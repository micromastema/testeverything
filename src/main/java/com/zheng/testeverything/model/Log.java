package com.zheng.testeverything.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 实体类(日志表)
 */
@Getter
@Setter
@NoArgsConstructor
public class Log {

    private Long id;
    /**
     * 账号
     */
    private String account;
    /**
     * 行为
     */
    private String action;
    /**
     * 日志信息
     */
    private String content;
    /**
     * 更新时间
     */
    private Date createTime;

}