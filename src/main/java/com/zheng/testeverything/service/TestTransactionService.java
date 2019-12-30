package com.zheng.testeverything.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

/**
 * @author zhengchentong on 2019-06-15
 */
@Service
public class TestTransactionService {

    public void test() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4Ffsd7EspeKbiNUk3p2S";
        String accessKeySecret = "A4uMfT0c38Cru2ttWMPF2qSGNhekYu";
        String bucketName = "qingclasstest";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        //ossClient.createBucket(bucketName);

        ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream("aaa".getBytes());
        PutObjectResult key = ossClient.putObject(bucketName, "key.txt", byteArrayInputStream);
//        key.getResponse().ge
        https://qingclasstest.oss-cn-hangzhou.aliyuncs.com/key?Expires=1577695279&OSSAccessKeyId=TMP.hhqHsRWdRDTZ3yExgH1udRiS7k1HrawDwsBdyxJeHuifWg6xBTXWXx21UsjAanUdSz1wejQU94EDeHFxaLpBxrDnnwZFALAeDpphoJ376Qu2XSupvf51iCA75cFEwj.tmp&Signature=84OOu4YL%2FtrQiU5sV8Joj%2F4rV9M%3D
        System.out.println(key);
        // 关闭OSSClient。
        ossClient.shutdown();

        OSS ossClient1 = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}
