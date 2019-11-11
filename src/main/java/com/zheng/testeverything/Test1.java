package com.zheng.testeverything;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhengchentong on 2019/10/30
 */
public class Test1 {
    public static void main(String[] args) {
        BigDecimal fenAmount = new BigDecimal(0);
        fenAmount = fenAmount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_UNNECESSARY);
        System.out.println(fenAmount);
    }
}
