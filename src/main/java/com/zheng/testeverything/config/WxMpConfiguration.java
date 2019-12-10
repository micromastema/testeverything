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

        WxMpDefaultConfigImpl ivykidConfigStorage = new WxMpDefaultConfigImpl();
        ivykidConfigStorage.setAppId("wxc81a45471bf3b23b");
        ivykidConfigStorage.setSecret("097b97292f056253438b3d8127cc5d72");
        ivykidConfigStorage.setToken("zgZ8");
        ivykidConfigStorage.setAesKey("O17RK6I7vEZSkicgeEInXvkQEy4FNIaseiOZofkkz1j");
        ivykidConfigStorage.setAccessToken("28_t0PzVzBzxeHZ0XmFOc_DsJg_zGtHjpmAg0ybB_AwuyXXeDwjQnXNroeTMSm3WikdP9KEqDvIzeA1_TdARNqHpC0-mGYRve1gscoEBWxVZLYbQj_sQEkb2ZTF31w9U5dV6pEbR2OcJy97roWkUERgAGAYIV");

        WxMpDefaultConfigImpl songshuConfigStorage = new WxMpDefaultConfigImpl();
        songshuConfigStorage.setAppId("wxd5903083dfc38215");
        songshuConfigStorage.setSecret("581d6339c7c0a3d52403135ed2b95472");
        songshuConfigStorage.setToken("zgZ8");
        songshuConfigStorage.setAesKey("O17RK6I7vEZSkicgeEInXvkQEy4FNIaseiOZofkkz1j");
        songshuConfigStorage.setAccessToken("28_K2eyrJMCBsQLoTuCcFOfFVsDNI5N0Xl4OgMgqY66jer4vdugxgAXDAqHmA8bA9hYAT0Dd10R4tqDLaC0by0VqzRBsTPurr0OxqTrkg_53o1JLvGMhcaDly5XqkbiDxaxJdczNsCPjYT8fgilDSKfAHANCU");

        Map<String,WxMpConfigStorage> wxMap = new HashMap<>();
        wxMap.put("appid", ivykidConfigStorage);
        wxMap.put("songshu", songshuConfigStorage);

        service.setMultiConfigStorages(wxMap);
        return service;
    }
}
