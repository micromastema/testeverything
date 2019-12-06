package com.zheng.testeverything.controller;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

    private final WxMpService wxMpService;

    public TestController(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @GetMapping("/checkSignature")
    public String checkSignature() {
        String appid = "";
        boolean haveAppConfig = wxMpService.switchover(appid);
        if (!haveAppConfig) {
            System.out.println("为找到公众号配置");
        }
        String signature = "";
        String timestamp = "";
        String nonce = "";
        String echostr = "";
        boolean b = wxMpService.checkSignature(timestamp, nonce, signature);
        List<String> openidList = new ArrayList<>();
        try {
            List<WxMpUser> wxMpUsers = wxMpService.getUserService().userInfoList(openidList);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        if (b) {
            return echostr;
        }
        return "非法请求";
    }


}
