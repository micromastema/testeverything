package com.zheng.testeverything.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zhengct
 * @date : 2020/09/04
 */
@Service
public class DataService {

    public List<String> importData(String path) {
        List<String> result = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile(path);
            String s = "";
            InputStreamReader in = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(in);
            while ((s = br.readLine()) != null) {
                result.add(s);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Map<String, String>> deala() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/a.txt");
        for (String s1 : s) {
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[0]);
            splitMap.put("num", split1[1]);
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> dealb3() {
        //TODO 人教版
        List<Map<String, String>> result = new ArrayList<>();

        List<String> line = importData("classpath:data/b3.txt");
        String[][] data = new String[10000][10000];
        //1年级上册 第一单元 数一数 几个图形
        Map<String, String> a = new HashMap<>();
        for (int i = 0; i < line.size(); i++) {
            String str = line.get(i);
            int n = str.length() - str.replaceAll("\t", "").length();
            data[i][n] = str;
        }
        int yiji = 0;
        int erji = 0;
        int sanji = 0;
        int siji = 0;
        int wuji =0;
        int liuji = 0;
        String bianhao = "";
        for (int i = 0; i < data.length; i++) {
            if (!StringUtils.isEmpty(data[i][0])) {
                yiji++;
                bianhao = yiji + "";
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("name", data[i][0].replaceAll("\t", ""));
                resultMap.put("num", bianhao);
                result.add(resultMap);
            }
            if (!StringUtils.isEmpty(data[i][1])) {
                erji++;
                bianhao = yiji + "-" + erji + "";
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("name", data[i][1].replaceAll("\t", ""));
                resultMap.put("num", bianhao);
                result.add(resultMap);
            }
            if (!StringUtils.isEmpty(data[i][2])) {
                sanji++;
                bianhao = yiji + "-" + erji + "-" + sanji;
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("name", data[i][2].replaceAll("\t", ""));
                resultMap.put("num", bianhao);
                result.add(resultMap);
            }
            if (!StringUtils.isEmpty(data[i][3])) {
                siji++;
                bianhao = yiji + "-" + erji + "-" + sanji + "-" + siji;
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("name", data[i][3].replaceAll("\t", ""));
                resultMap.put("num", bianhao);
                result.add(resultMap);
            }
            if (!StringUtils.isEmpty(data[i][4])) {
                wuji++;
                bianhao = yiji + "-" + erji + "-" + sanji + "-" + siji+"-"+wuji;
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("name", data[i][4].replaceAll("\t", ""));
                resultMap.put("num", bianhao);
                result.add(resultMap);
            }
            if (!StringUtils.isEmpty(data[i][5])) {
                liuji++;
                bianhao = yiji + "-" + erji + "-" + sanji + "-" + siji+"-"+wuji+"-"+liuji;
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("name", data[i][5].replaceAll("\t", ""));
                resultMap.put("num", bianhao);
                result.add(resultMap);
            }

            //1-1-1-1
            //1-1-2
            //1-2
            //2
            if (i > 1 && !StringUtils.isEmpty(data[i][0])) {
                erji = 0;
                sanji = 0;
                siji = 0;
                wuji = 0;
                liuji = 0;
                bianhao = "";
            }
            if (i > 1 && !StringUtils.isEmpty(data[i][1])) {
                sanji = 0;
                siji = 0;
                wuji = 0;
                liuji = 0;
                bianhao = "";
            }
            if (i > 1 && !StringUtils.isEmpty(data[i][2])) {
                siji = 0;
                wuji = 0;
                liuji = 0;
                bianhao = "";
            }
            if (i > 1 && !StringUtils.isEmpty(data[i][3])) {
                wuji = 0;
                liuji = 0;
                bianhao = "";
            }
            if (i > 1 && !StringUtils.isEmpty(data[i][4])) {
                liuji = 0;
                bianhao = "";
            }
        }
        return result;
    }

    public List<Map<String, String>> dealc() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/c.txt");
        for (String s1 : s) {
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald1() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d1.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald2() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d2.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald4() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d4.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald5() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d5.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald6() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d6.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald7() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d7.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald8() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d8.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }

    public List<Map<String, String>> deald9() {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> s = importData("classpath:data/d9.txt");
        for (String s1 : s) {
            if (StringUtils.isEmpty(s1)) {
                continue;
            }
            String[] split1 = s1.split("\t");
            Map<String, String> splitMap = new HashMap<>();
            splitMap.put("name", split1[1]);
            splitMap.put("num", split1[0].replaceAll("\\.", "-"));
            result.add(splitMap);
            System.out.println(split1[0]);
            System.out.println(split1[1]);
        }
        return result;
    }
}
