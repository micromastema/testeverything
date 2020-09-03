package com.zheng.testeverything.base;

import org.apache.commons.lang3.StringUtils;

/**
 * 排序编辑类(只限于单表)
 *
 * @author zhengct on 2019/1/2
 */
public class OrderBean {
    private StringBuilder sb = new StringBuilder(" order by ");

    public OrderBean() {
    }

    public OrderBean(String orderCol, OrderEnum orderType) {
        if (StringUtils.isNotEmpty(orderCol) && orderType != null) {
            this.sb.append(orderCol).append(" ").append(orderType);
        }
    }

    public OrderBean add(String orderCol, OrderEnum orderType) {
        if (StringUtils.isNotEmpty(orderCol) && orderType != null) {
            if (sb.length() > 10) {
                sb.append(",");
            }
            sb.append(orderCol).append(" ").append(orderType);
        }
        return this;
    }

    public String getOrderSql() {
        return sb.length() > 10 ? sb.toString() : "";
    }

    public boolean wasNotConfigured() {
        return sb.length() <= 10;
    }

}