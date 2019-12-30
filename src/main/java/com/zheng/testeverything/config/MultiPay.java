package com.zheng.testeverything.config;

import com.github.binarywang.wxpay.service.WxPayService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengct
 * @date 2019/12/30
 */
public class MultiPay {

    private Map<String, WxPayService> multiPayMap = new HashMap<>();

    public WxPayService getWxPayService(String appid) {
        return multiPayMap.get(appid);
    }

    public void setWxPayService(String appid, WxPayService wxPayService) {
        multiPayMap.put(appid, wxPayService);
    }

}
