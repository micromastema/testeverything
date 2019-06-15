package com.zheng.testeverything.model2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengchentong on 2019-06-14
 */
@Mapper
public interface TestMapper2 {

    @Select("select teacher from t1 where username = #{username}")
    public String getid(String username);

    /**
     * aa
     *
     * @param a a
     * @param b b
     * @param c c
     * @param d c
     * @param e c
     * @param f c
     * @param g c
     */
    @Insert("INSERT INTO `database2`.`t1`(`username`, `password`, `sex`, `class`, `teacher`, `teachername`, `father`, `mather`, `parent`, `son`, `sister`, `haha`) VALUES (#{a},  #{b} ,  #{c} ,  #{d} ,  #{e} ,  #{f} ,  #{g} ,  #{a} ,  #{b} ,  #{a} ,  #{a} ,  #{a} )")
    public void insert(String a, String b, String c, String d, String e, String f, String g);

}
