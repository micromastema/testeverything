package com.zheng.testeverything.controller;

import com.zheng.testeverything.base.OrderBean;
import com.zheng.testeverything.base.OrderEnum;
import com.zheng.testeverything.base.Page;
import com.zheng.testeverything.base.PageList;
import com.zheng.testeverything.mapper.LogMapper;
import com.zheng.testeverything.model.Log;
import com.zheng.testeverything.model.field.LogConstants;
import com.zheng.testeverything.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private LogService logService;

    @GetMapping("/t")
    public void test(){
        Log byId = logMapper.findById(3L);
        Log byId1 = logService.findById(5L);

        Log build = Log.builder().id(3L).account("1").build();
        Page page = new Page(1, 10);
        OrderBean orderBean = new OrderBean(LogConstants.ID, OrderEnum.DESC);
        List<Log> byExample = logMapper.findByExample(build, new Page(), orderBean);

        Integer byExampleCount = logMapper.findByExampleCount(build);
        PageList<Log> byExamplePage = logService.findByExamplePage(build, page, orderBean);

        Integer integer = logMapper.deleteById(3L);
        build.setId(null);
        Integer integer1 = logMapper.deleteBatch(build);
        Log build1 = Log.builder().createTime(new Date()).account("1").action("2").content("3").build();
        Integer insert = logMapper.insert(build1);
        Log build2 = Log.builder().createTime(new Date()).account("1").action("2").content("3").build();
        List<Log> list = new ArrayList<>();
        list.add(build2);
        list.add(build2);
        Integer integer2 = logMapper.insertBatch(list);
        Integer integer3 = logMapper.deleteById(build1.getId());
        Integer integer4 = logMapper.deleteBatch(build1);
        Log build3 = Log.builder().createTime(new Date()).account("1").action("2").content("3").build();
        List<Object> idList = new ArrayList<>();
        idList.add("1");
        List<Log> byList1 = logMapper.findByList(Log.builder().build(), LogConstants.ACCOUNT, idList, page, orderBean);

        Integer integer5 = logMapper.updateById(build1.getId(), build1);

        Log build11 = new Log();
        build11.setAccount("33");
        build11.setAction("33");
        build11.setContent("33");
        build11.setCreateTime(new Date());
        Integer integer6 = logMapper.updateByExample(build11, build2);

        PageList<Log> byExamplePage1 = logService.findByExamplePage(build1, page, orderBean);
        int i = logService.deleteById(2L);
        Log byId2 = logService.findById(2L);
        Log build4 = Log.builder().createTime(new Date()).account("1").action("2").content("3").build();

        int insert1 = logService.insert(build4);
        int i1 = logService.updateById(build2);
        System.out.println("");

    }
}
