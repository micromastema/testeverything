package com.zheng.testeverything.model.field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 实体类(知识点表
 * )
 */
@Getter
@Setter
@NoArgsConstructor
public class TkTbKnwtree {

    private Long id;
    /**
     * 知识点编号
     */
    private String knwId;
    /**
     * 知识点父级编号
     */
    private String knwPid;
    /**
     * 知识点名称
     */
    private String knwName;
    /**
     * 知识点排序
     */
    private Integer knwIndex;
    /**
     * 流水编号
     */
    private Integer knwFlowId;
    /**
     * 级次码
     */
    private Integer knwLevel;
    /**
     * 级次码
     */
    private String knwLevelCode;
    /**
     * 是否叶子节点
     */
    private Integer knwIsLeaf;
    /**
     * 知识体系类型（1：公立校体系；2：校外体系；3：素养体系等）
     */
    private Integer knwType;
    /**
     * 学科
     */
    private String knwSubject;
    /**
     * 学科名
     */
    private String subjectName;
    /**
     * 学段
     */
    private String knwStage;
    /**
     * 学段名
     */
    private String stageName;
    /**
     * 别名
     */
    private String knwAliasName;
    /**
     * title顺序
     */
    private String knwTitleIndex;
    /**
     * 树节点归属 0
     */
    private Integer knwTreeType;
    /**
     * 知识点名称首字母简拼
     */
    private String knwNamePinyin;
    /**
     * 知识点名称全拼音
     */
    private String knwNameFullPinyin;
    /**
     * 是否可以选择 0 可以 1 不可以
     */
    private Integer chooseType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人邮箱
     */
    private String creator;
    /**
     * 创建人
     */
    private String creatorName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改邮箱
     */
    private String editor;
    /**
     * 修改时间
     */
    private Date editTime;
    /**
     * 修改人名称
     */
    private String editorName;
    /**
     * 逻辑删除
     */
    private Integer flagUse;
    /**
     * 来源系统编号（1：题库；2：作业；3：测评；4：iTeach题库；5：天利）
     */
    private Integer sysCode;

    private String num;

    private String tpsLevelCode;
}