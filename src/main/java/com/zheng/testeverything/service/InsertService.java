package com.zheng.testeverything.service;

import com.zheng.testeverything.mapper.TkTbKnwtreeMapper;
import com.zheng.testeverything.model.field.TkTbKnwtree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : zhengct
 * @date : 2020/09/07
 */
@Service
public class InsertService {

    @Autowired
    private DataService dataService;

    @Autowired
    private TkTbKnwtreeMapper tkTbKnwtreeMapper;

    private Long id = 0L;

    public void deala() {
        List<Map<String, String>> deala = dataService.deala();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "3";
            String subjectName = "英语";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;

    }

    private String getPId(String num, List<Map<String, String>> deala) {
        String[] split = num.split("-");
        String pnum = "";
        for (int i = 0; i < split.length - 1; i++) {
            pnum = pnum + split[i];
        }
        for (Map<String, String> stringStringMap : deala) {
            if (stringStringMap.get("num").equals(pnum)) {
                return stringStringMap.get("knwId");
            }
        }
        return null;
    }

    private String getPid1(String num, List<TkTbKnwtree> entityList) {
        //1  253@
        //1-1 253@254@
        //1-1-1 253@254@255
        if (num.split("-").length == 1) {
            return "-1";
        }
        int i=num.lastIndexOf("-");
        String subNum = num.substring(0, i);
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            if (tkTbKnwtree.getNum().equals(subNum)) {
                return tkTbKnwtree.getKnwId();
            }
        }
        return null;
    }

    private Integer getKnwIndex(String num) {
        String[] split = num.split("-");
        String s = split[split.length - 1];
        return Integer.valueOf(s);
    }

    private String getLevelCode(String num, List<TkTbKnwtree> entityList, Long id) {
        //1  253@
        //1-1 253@254@
        //1-1-1 253@254@255
        if (num.split("-").length == 1) {
            return id + "@";
        }
        int i=num.lastIndexOf("-");
        String subNum = num.substring(0, i);
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            if (tkTbKnwtree.getNum().equals(subNum)) {
                return tkTbKnwtree.getKnwLevelCode() + id + "@";
            }
        }
        return null;
    }


    public void dealb(){
        List<Map<String, String>> deala = dataService.dealb();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "3";
            String subjectName = "英语";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void dealc(){
        List<Map<String, String>> deala = dataService.dealc();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "1";
            String subjectName = "语文";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald1(){
        List<Map<String, String>> deala = dataService.deald1();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald2(){
        List<Map<String, String>> deala = dataService.deald2();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald4(){
        List<Map<String, String>> deala = dataService.deald4();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald5(){
        List<Map<String, String>> deala = dataService.deald5();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald6(){
        List<Map<String, String>> deala = dataService.deald6();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald7(){
        List<Map<String, String>> deala = dataService.deald7();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            if (tkTbKnwtree.getKnwPid() == null) {
                System.out.println("");
            }
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald8(){
        List<Map<String, String>> deala = dataService.deald8();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            if (tkTbKnwtree.getKnwPid() == null) {
                System.out.println("");
            }
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }

    public void deald9(){
        List<Map<String, String>> deala = dataService.deald9();
        List<TkTbKnwtree> entityList = new ArrayList<>();
        for (Map<String, String> stringStringMap : deala) {
            id++;
            String num = stringStringMap.get("num").replaceAll(" ","");
            String name = stringStringMap.get("name");
            String knwId = String.valueOf(SnowFlake.nextNumber());
            String pId = "";
            if (num.split("-").length == 1) {
                pId = "-1";
            } else {
                pId = getPid1(num, entityList);
            }
            Integer knwIndex = getKnwIndex(num);
            Integer flowId = id.intValue();
            Integer level = num.split("-").length;

            String levelCode = getLevelCode(num, entityList, id);
            //第二遍循环再赋值 先初始化为1 是否叶子节点1是 0否
            Integer knwIsLeaf = 1;
            Integer knwType = 2;
            //====小学英语
            String knwSubject = "2";
            String subjectName = "数学";
            String knwStage = "170";
            String stageName = "小学";
            //====
            Integer knwTreeType = 1;
            Integer chooseType = 0;
            TkTbKnwtree entity = new TkTbKnwtree();
            entity.setId(id);
            entity.setKnwId(knwId);
            entity.setKnwPid(pId);
            entity.setKnwName(name);
            entity.setKnwIndex(knwIndex);
            entity.setKnwFlowId(flowId);
            entity.setKnwLevel(level);
            entity.setKnwLevelCode(levelCode);
            entity.setKnwIsLeaf(knwIsLeaf);
            entity.setKnwType(knwType);
            entity.setKnwSubject(knwSubject);
            entity.setSubjectName(subjectName);
            entity.setKnwStage(knwStage);
            entity.setStageName(stageName);
            entity.setKnwAliasName("");
            entity.setKnwTitleIndex("");
            entity.setKnwTreeType(knwTreeType);
            entity.setKnwNamePinyin("");
            entity.setKnwNameFullPinyin("");
            entity.setChooseType(chooseType);
            entity.setRemark("");
            entity.setCreator("daoru");
            entity.setCreatorName("");
            entity.setCreateTime(new Date());
            entity.setEditor("");
            entity.setEditTime(new Date());
            entity.setEditorName("");
            entity.setFlagUse(1);
            entity.setSysCode(1);
            entity.setNum(num);

            entityList.add(entity);
            stringStringMap.put("knwId", knwId);
        }

        for (TkTbKnwtree tkTbKnwtree : entityList) {
            for (TkTbKnwtree tbKnwtree : entityList) {
                if (tkTbKnwtree.getKnwId().equals(tbKnwtree.getKnwPid())) {
                    //是否叶子节点1是 0否
                    tkTbKnwtree.setKnwIsLeaf(0);
                }
            }
        }
        for (TkTbKnwtree tkTbKnwtree : entityList) {
            System.out.println(tkTbKnwtree.getId());
            if (tkTbKnwtree.getKnwPid() == null) {
                System.out.println("");
            }
            tkTbKnwtreeMapper.insert(tkTbKnwtree);
        }
        return;
    }
}
