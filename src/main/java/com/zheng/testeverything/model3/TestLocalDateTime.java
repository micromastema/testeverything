package com.zheng.testeverything.model3;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author zhengchentong on 2019/11/6
 */
@RestController
@RequestMapping("/test")
public class TestLocalDateTime {

    @PostMapping("/test")
    public String test(@RequestBody Test test) {
        System.out.println(test);
        return "a";
    }

    @Getter
    @Setter
    @ToString
    private static class Test {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        private LocalDateTime localDateTime;

    }
}
