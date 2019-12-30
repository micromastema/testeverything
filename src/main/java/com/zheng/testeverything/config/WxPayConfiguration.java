package com.zheng.testeverything.config;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zhengct
 * @date 2019/12/30
 */
@Component
public class WxPayConfiguration {

    @Bean
    public MultiPay getPayService(){
        MultiPay multiPay = new MultiPay();
        for (int i = 1; i < 3; i++) {
            WxPayConfig payConfig = new WxPayConfig();
            payConfig.setAppId(i+"");
            payConfig.setMchId(i+"");
            payConfig.setMchKey(i+"");
            payConfig.setKeyPath(i+"");

            WxPayService wxPayService = new WxPayServiceImpl();
            wxPayService.setConfig(payConfig);
            multiPay.setWxPayService(i+"", wxPayService);
        }
        return multiPay;
    }
}
