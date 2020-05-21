package com.zheng.testeverything;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {


    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://kafka-zk1.neibu.koolearn.com:22181/neibu";
    private static String user = "college";
    private static String password = "35f2";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    @RequestMapping("/test2")
    public String test2() throws Exception {
        Class.forName(driverName);
        conn = DriverManager.getConnection(url,user,password);
        stmt = conn.createStatement();
        String sql = "show databases;";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        if ( rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
        return "ok";
    }
}
