package com.zheng.testeverything.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WxMpConfiguration {

    @Bean
    public WxMpService wxMpService() {
        WxMpService service = new WxMpServiceImpl();

        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(null);
        configStorage.setSecret(null);
        configStorage.setToken(null);
        configStorage.setAesKey(null);

        Map<String,WxMpConfigStorage> wxMap = new HashMap<>();
        wxMap.put("appid", configStorage);

        service.setMultiConfigStorages(wxMap);
        return service;
    }
}
