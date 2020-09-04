package com.zheng.testeverything.model;

import lombok.*;

import java.util.Date;

/**
 * 实体类(日志表)
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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