package com.zheng.testeverything;

import com.zheng.testeverything.model1.TestMapper1;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class TesteverythingApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("a");
    }

    @Autowired
    private TestMapper1 testMapper;

    @Test
    public void test1(){
        testMapper.getid("10");
    }

    @Test
    public void test2(){
        int a= 0;
        while(true){
            a=a+1;
            System.out.println(a);
            String b = a+1+"";
            String c = a+2+"";
            String d = a+3+"";
            String e = a+4+"";
            String f = a+5+"";
            String g = a+6+"";
            testMapper.insert(String.valueOf(a),b,c,d,e,f,g);
        }
    }

    @Test
    public void test3(){
        Random random = new Random();
        LocalDateTime now = LocalDateTime.now();
        for(int i =0;i<1000;i++){
            int a = random.nextInt(50000);
            String getid = testMapper.getid(Integer.toString(a));
//            System.out.println(i);
        }
        LocalDateTime now1 = LocalDateTime.now();

        Duration between = Duration.between(now, now1);
        long l = between.toMillis();
        System.out.println(l);
        //20 13.4
        //40 13.2
        //100 13.6
        //200 13.4
        //300 13.5
        //400 13.7
        //500 13.6
        //600 13.7
    }

    @Test
    public void test4() throws IOException {
        getMediaV2("wxb4e889634c068377", "Rx7lZ3cY8l838NToSc41EkVpFKcK4sk6xJL-JYRWvJRtgH0xP7cgYgl-lADE0vSF","24__831FXVbqZe3OUclTx9NRfLrpy1AiQi_KWk8jMV6ijsPiC3FUQcbeJ5z3zo_BrN5JVURMUw-MncJd_Bol-31ddhvkv0RS6_u3Sz_qwhvFkFvqQSpeG7Ay_CwzbMtyB2lkvrbsXGJvejMgi4xPOIfAGAIHB");
    }

    /**
     * 下载语音文件流
     *
     * @param appId
     * @param mediaId
     * @return 可能为null
     */
    public byte[] getMediaV2(String appId, String mediaId,String accesstoken) throws IOException {
        Long time = System.currentTimeMillis();
        byte[] stream = null;
        //获取请求appId的accessToken
        String accessToken = accesstoken;
        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token="+accessToken+"&media_id="+mediaId;
        //发起请求 打印异常信息
        HttpPost httpPost = new HttpPost(url);
        try {
            HttpResponse response = HttpClients.createDefault().execute(httpPost);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                return stream;
            }
            HttpEntity responseEntity = response.getEntity();
            stream= EntityUtils.toByteArray(responseEntity);
        } catch (IOException e) {
        }
        File file = new File("/a.amr");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream(4096);
        int n;
        while ((n = in.read(stream)) != -1) {
            out.write(stream, 0, n);
        }
        in.close();
        out.close();
        return stream;
    }

}
