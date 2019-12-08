package com.zheng.testeverything.config;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author zhengct
 * @date 2019/12/8
 */
@Configuration
public class RocketMQConfig {


    public Properties getProperties(){

        Properties properties=new Properties();
        /**
         * 键的首字母必须大写
         */
        properties.setProperty("AccessKey","LTAI4Ffsd7EspeKbiNUk3p2S");
        //
        properties.setProperty("SecretKey","A4uMfT0c38Cru2ttWMPF2qSGNhekYu");
        //
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        // 顺序消息消费失败进行重试前的等待时间，单位(毫秒)
        properties.put(PropertyKeyConst.SuspendTimeMillis, "100");
        // 消息消费失败时的最大重试次数
        properties.put(PropertyKeyConst.MaxReconsumeTimes, "20");
        //
        properties.put(PropertyKeyConst.NAMESRV_ADDR, "http://1034468624965622.mqrest.cn-hangzhou.aliyuncs.com:8080");
        return  properties;
    }
}