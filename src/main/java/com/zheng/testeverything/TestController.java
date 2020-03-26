package com.zheng.testeverything;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/a")
    public String a(){
        return "{\"code\":0,\"data\":[{\"productId\":\"100001\",\"productName\":\"小度人工智能音箱\",\"productPrice\":99,\"productNum\":2,\"productImage\":\"1.jpg\",\"checked\":false},{\"productId\":\"100002\",\"productName\":\"小度小金刚\",\"productPrice\":159,\"productNum\":5,\"productImage\":\"2.jpg\",\"checked\":true},{\"productId\":\"100003\",\"productName\":\"小度在家1c\",\"productPrice\":499,\"productNum\":1,\"productImage\":\"3.jpg\",\"checked\":true},{\"productId\":\"100004\",\"productName\":\"小度大金刚\",\"productPrice\":199,\"productNum\":3,\"productImage\":\"4.jpg\",\"checked\":true},{\"productId\":\"100005\",\"productName\":\"小度青春版\",\"productPrice\":69,\"productNum\":2,\"productImage\":\"5.png\",\"checked\":false},{\"productId\":\"100006\",\"productName\":\"小度人工智能Pro\",\"productPrice\":299,\"productNum\":1,\"productImage\":\"6.jpg\",\"checked\":true}],\"message\":\"\"}";
    }

    @GetMapping("/b")
    public String b(){
        return "{\"code\":0,\"data\":[{\"addressId\":\"100001\",\"userName\":\"河畔一角\",\"streetName\":\"北京市朝阳区\",\"postCode\":\"100001\",\"tel\":17088888888,\"isDefault\":false},{\"addressId\":\"100002\",\"userName\":\"Jack Ma\",\"streetName\":\"杭州市西湖区\",\"postCode\":\"100002\",\"tel\":18099999999,\"isDefault\":true},{\"addressId\":\"100003\",\"userName\":\"雷军\",\"streetName\":\"北京市昌平区\",\"postCode\":\"100003\",\"tel\":16022222222,\"isDefault\":false},{\"addressId\":\"100004\",\"userName\":\"Robin Li\",\"streetName\":\"北京市海淀区\",\"postCode\":\"100004\",\"tel\":15033333333,\"isDefault\":false},{\"addressId\":\"100005\",\"userName\":\"Pony Ma\",\"streetName\":\"深圳市南山区\",\"postCode\":\"100005\",\"tel\":13055555555,\"isDefault\":false},{\"addressId\":\"100006\",\"userName\":\"刘强东\",\"streetName\":\"北京市亦庄经济开发区\",\"postCode\":\"100006\",\"tel\":12055555555,\"isDefault\":false}],\"message\":\"\"}";
    }
}
