package com.zheng.testeverything;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    @Qualifier("hiveJdbcDataSource")
    org.apache.tomcat.jdbc.pool.DataSource jdbcDataSource;

    @RequestMapping("/test2")
    public String test2() throws Exception {
        List<String> list = new ArrayList<>();
        Statement statement = jdbcDataSource.getConnection().createStatement();
        String sql = "select * from im_pe_im_user limit 10";
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            list.add(res.getString(2));
        }
        return "ok";
    }
}
