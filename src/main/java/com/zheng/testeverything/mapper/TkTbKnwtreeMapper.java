package com.zheng.testeverything.mapper;

import com.zheng.testeverything.model.field.TkTbKnwtree;
import com.zheng.testeverything.base.OrderBean;
import com.zheng.testeverything.base.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 知识点表

 *
 * @author zhengchentong on 2019/10/21
 */
@Mapper
@Component
public interface TkTbKnwtreeMapper {

    /**
     * 插入一条记录
     *
     * @param tkTbKnwtree tkTbKnwtree
     * @return 1插入成功 0插入失败
    */
    @Insert({"<script>",
        "INSERT INTO `tk_tb_knwtree`( ",
            "`id`,",
            "`knw_id`,",
            "`knw_pid`,",
            "`knw_name`,",
            "`knw_index`,",
            "`knw_flow_id`,",
            "`knw_level`,",
            "`knw_level_code`,",
            "`knw_is_leaf`,",
            "`knw_type`,",
            "`knw_subject`,",
            "`subject_name`,",
            "`knw_stage`,",
            "`stage_name`,",
            "`knw_alias_name`,",
            "`knw_title_index`,",
            "`knw_tree_type`,",
            "`knw_name_pinyin`,",
            "`knw_name_full_pinyin`,",
            "`choose_type`,",
            "`remark`,",
            "`creator`,",
            "`creator_name`,",
            "`create_time`,",
            "`editor`,",
            "`edit_time`,",
            "`editor_name`,",
            "`flag_use`,",
            "`sys_code`",
            ")",
            "values (",
            "#{id},",
            "#{knwId},",
            "#{knwPid},",
            "#{knwName},",
            "#{knwIndex},",
            "#{knwFlowId},",
            "#{knwLevel},",
            "#{knwLevelCode},",
            "#{knwIsLeaf},",
            "#{knwType},",
            "#{knwSubject},",
            "#{subjectName},",
            "#{knwStage},",
            "#{stageName},",
            "#{knwAliasName},",
            "#{knwTitleIndex},",
            "#{knwTreeType},",
            "#{knwNamePinyin},",
            "#{knwNameFullPinyin},",
            "#{chooseType},",
            "#{remark},",
            "#{creator},",
            "#{creatorName},",
            "#{createTime},",
            "#{editor},",
            "#{editTime},",
            "#{editorName},",
            "#{flagUse},",
            "#{sysCode}",
            ")",
            "</script>"
    })
    Integer insert(TkTbKnwtree tkTbKnwtree);

    /**
     * 批量删除
     *
     * @param tkTbKnwtree tkTbKnwtree
     * @return int
     */
    @Delete({"<script>",
            "DELETE FROM `tk_tb_knwtree`",
            "<where>",
            "<if test='id != null'>and id = #{id}</if>",
            "<if test='knwId != null'>and knw_id = #{knwId}</if>",
            "<if test='knwPid != null'>and knw_pid = #{knwPid}</if>",
            "<if test='knwName != null'>and knw_name = #{knwName}</if>",
            "<if test='knwIndex != null'>and knw_index = #{knwIndex}</if>",
            "<if test='knwFlowId != null'>and knw_flow_id = #{knwFlowId}</if>",
            "<if test='knwLevel != null'>and knw_level = #{knwLevel}</if>",
            "<if test='knwLevelCode != null'>and knw_level_code = #{knwLevelCode}</if>",
            "<if test='knwIsLeaf != null'>and knw_is_leaf = #{knwIsLeaf}</if>",
            "<if test='knwType != null'>and knw_type = #{knwType}</if>",
            "<if test='knwSubject != null'>and knw_subject = #{knwSubject}</if>",
            "<if test='subjectName != null'>and subject_name = #{subjectName}</if>",
            "<if test='knwStage != null'>and knw_stage = #{knwStage}</if>",
            "<if test='stageName != null'>and stage_name = #{stageName}</if>",
            "<if test='knwAliasName != null'>and knw_alias_name = #{knwAliasName}</if>",
            "<if test='knwTitleIndex != null'>and knw_title_index = #{knwTitleIndex}</if>",
            "<if test='knwTreeType != null'>and knw_tree_type = #{knwTreeType}</if>",
            "<if test='knwNamePinyin != null'>and knw_name_pinyin = #{knwNamePinyin}</if>",
            "<if test='knwNameFullPinyin != null'>and knw_name_full_pinyin = #{knwNameFullPinyin}</if>",
            "<if test='chooseType != null'>and choose_type = #{chooseType}</if>",
            "<if test='remark != null'>and remark = #{remark}</if>",
            "<if test='creator != null'>and creator = #{creator}</if>",
            "<if test='creatorName != null'>and creator_name = #{creatorName}</if>",
            "<if test='createTime != null'>and create_time = #{createTime}</if>",
            "<if test='editor != null'>and editor = #{editor}</if>",
            "<if test='editTime != null'>and edit_time = #{editTime}</if>",
            "<if test='editorName != null'>and editor_name = #{editorName}</if>",
            "<if test='flagUse != null'>and flag_use = #{flagUse}</if>",
            "<if test='sysCode != null'>and sys_code = #{sysCode}</if>",
            "</where>",
            "</script>"
    })
    Integer deleteBatch(TkTbKnwtree tkTbKnwtree);

    /**
     * 按id删除
     *
     * @param id id
     * @return int
     */
    @Delete({"<script>",
            "DELETE FROM `tk_tb_knwtree` where id = #{id}",
            "</script>"
    })
    Integer deleteById(Integer id);

    /**
     * 根据id更新数据
     *
     * @param id        id
     * @param tkTbKnwtree tkTbKnwtree
     * @return int
     */
    @Update({"<script>",
            "UPDATE `tk_tb_knwtree`",
            "<set>",
            "<if test='tkTbKnwtree.id != null'>`id` = #{tkTbKnwtree.id},</if>",
            "<if test='tkTbKnwtree.knwId != null'>`knw_id` = #{tkTbKnwtree.knwId},</if>",
            "<if test='tkTbKnwtree.knwPid != null'>`knw_pid` = #{tkTbKnwtree.knwPid},</if>",
            "<if test='tkTbKnwtree.knwName != null'>`knw_name` = #{tkTbKnwtree.knwName},</if>",
            "<if test='tkTbKnwtree.knwIndex != null'>`knw_index` = #{tkTbKnwtree.knwIndex},</if>",
            "<if test='tkTbKnwtree.knwFlowId != null'>`knw_flow_id` = #{tkTbKnwtree.knwFlowId},</if>",
            "<if test='tkTbKnwtree.knwLevel != null'>`knw_level` = #{tkTbKnwtree.knwLevel},</if>",
            "<if test='tkTbKnwtree.knwLevelCode != null'>`knw_level_code` = #{tkTbKnwtree.knwLevelCode},</if>",
            "<if test='tkTbKnwtree.knwIsLeaf != null'>`knw_is_leaf` = #{tkTbKnwtree.knwIsLeaf},</if>",
            "<if test='tkTbKnwtree.knwType != null'>`knw_type` = #{tkTbKnwtree.knwType},</if>",
            "<if test='tkTbKnwtree.knwSubject != null'>`knw_subject` = #{tkTbKnwtree.knwSubject},</if>",
            "<if test='tkTbKnwtree.subjectName != null'>`subject_name` = #{tkTbKnwtree.subjectName},</if>",
            "<if test='tkTbKnwtree.knwStage != null'>`knw_stage` = #{tkTbKnwtree.knwStage},</if>",
            "<if test='tkTbKnwtree.stageName != null'>`stage_name` = #{tkTbKnwtree.stageName},</if>",
            "<if test='tkTbKnwtree.knwAliasName != null'>`knw_alias_name` = #{tkTbKnwtree.knwAliasName},</if>",
            "<if test='tkTbKnwtree.knwTitleIndex != null'>`knw_title_index` = #{tkTbKnwtree.knwTitleIndex},</if>",
            "<if test='tkTbKnwtree.knwTreeType != null'>`knw_tree_type` = #{tkTbKnwtree.knwTreeType},</if>",
            "<if test='tkTbKnwtree.knwNamePinyin != null'>`knw_name_pinyin` = #{tkTbKnwtree.knwNamePinyin},</if>",
            "<if test='tkTbKnwtree.knwNameFullPinyin != null'>`knw_name_full_pinyin` = #{tkTbKnwtree.knwNameFullPinyin},</if>",
            "<if test='tkTbKnwtree.chooseType != null'>`choose_type` = #{tkTbKnwtree.chooseType},</if>",
            "<if test='tkTbKnwtree.remark != null'>`remark` = #{tkTbKnwtree.remark},</if>",
            "<if test='tkTbKnwtree.creator != null'>`creator` = #{tkTbKnwtree.creator},</if>",
            "<if test='tkTbKnwtree.creatorName != null'>`creator_name` = #{tkTbKnwtree.creatorName},</if>",
            "<if test='tkTbKnwtree.createTime != null'>`create_time` = #{tkTbKnwtree.createTime},</if>",
            "<if test='tkTbKnwtree.editor != null'>`editor` = #{tkTbKnwtree.editor},</if>",
            "<if test='tkTbKnwtree.editTime != null'>`edit_time` = #{tkTbKnwtree.editTime},</if>",
            "<if test='tkTbKnwtree.editorName != null'>`editor_name` = #{tkTbKnwtree.editorName},</if>",
            "<if test='tkTbKnwtree.flagUse != null'>`flag_use` = #{tkTbKnwtree.flagUse},</if>",
            "<if test='tkTbKnwtree.sysCode != null'>`sys_code` = #{tkTbKnwtree.sysCode}</if>",
            "</set>",
            "WHERE id = #{id}",
            "</script>"
    })
    Integer updateById(@Param("id") Integer id, @Param("tkTbKnwtree") TkTbKnwtree tkTbKnwtree);

    /**
     * 批量更新数据
     *
     * @param search 条件对象
     * @param value  更新对象
     * @return int
     */
    @Update({"<script>",
            "UPDATE `tk_tb_knwtree`",
            "<set>",
            "<if test='value.id != null'>`id` = #{value.id}</if>",
            "<if test='value.knwId != null'>`knw_id` = #{value.knwId}</if>",
            "<if test='value.knwPid != null'>`knw_pid` = #{value.knwPid}</if>",
            "<if test='value.knwName != null'>`knw_name` = #{value.knwName}</if>",
            "<if test='value.knwIndex != null'>`knw_index` = #{value.knwIndex}</if>",
            "<if test='value.knwFlowId != null'>`knw_flow_id` = #{value.knwFlowId}</if>",
            "<if test='value.knwLevel != null'>`knw_level` = #{value.knwLevel}</if>",
            "<if test='value.knwLevelCode != null'>`knw_level_code` = #{value.knwLevelCode}</if>",
            "<if test='value.knwIsLeaf != null'>`knw_is_leaf` = #{value.knwIsLeaf}</if>",
            "<if test='value.knwType != null'>`knw_type` = #{value.knwType}</if>",
            "<if test='value.knwSubject != null'>`knw_subject` = #{value.knwSubject}</if>",
            "<if test='value.subjectName != null'>`subject_name` = #{value.subjectName}</if>",
            "<if test='value.knwStage != null'>`knw_stage` = #{value.knwStage}</if>",
            "<if test='value.stageName != null'>`stage_name` = #{value.stageName}</if>",
            "<if test='value.knwAliasName != null'>`knw_alias_name` = #{value.knwAliasName}</if>",
            "<if test='value.knwTitleIndex != null'>`knw_title_index` = #{value.knwTitleIndex}</if>",
            "<if test='value.knwTreeType != null'>`knw_tree_type` = #{value.knwTreeType}</if>",
            "<if test='value.knwNamePinyin != null'>`knw_name_pinyin` = #{value.knwNamePinyin}</if>",
            "<if test='value.knwNameFullPinyin != null'>`knw_name_full_pinyin` = #{value.knwNameFullPinyin}</if>",
            "<if test='value.chooseType != null'>`choose_type` = #{value.chooseType}</if>",
            "<if test='value.remark != null'>`remark` = #{value.remark}</if>",
            "<if test='value.creator != null'>`creator` = #{value.creator}</if>",
            "<if test='value.creatorName != null'>`creator_name` = #{value.creatorName}</if>",
            "<if test='value.createTime != null'>`create_time` = #{value.createTime}</if>",
            "<if test='value.editor != null'>`editor` = #{value.editor}</if>",
            "<if test='value.editTime != null'>`edit_time` = #{value.editTime}</if>",
            "<if test='value.editorName != null'>`editor_name` = #{value.editorName}</if>",
            "<if test='value.flagUse != null'>`flag_use` = #{value.flagUse}</if>",
            "<if test='value.sysCode != null'>`sys_code` = #{value.sysCode}</if>",
            "</set>",
            "<where>",
            "<if test='search.id != null'>AND `id` = #{search.id}</if>",
            "<if test='search.knwId != null'>AND `knw_id` = #{search.knwId}</if>",
            "<if test='search.knwPid != null'>AND `knw_pid` = #{search.knwPid}</if>",
            "<if test='search.knwName != null'>AND `knw_name` = #{search.knwName}</if>",
            "<if test='search.knwIndex != null'>AND `knw_index` = #{search.knwIndex}</if>",
            "<if test='search.knwFlowId != null'>AND `knw_flow_id` = #{search.knwFlowId}</if>",
            "<if test='search.knwLevel != null'>AND `knw_level` = #{search.knwLevel}</if>",
            "<if test='search.knwLevelCode != null'>AND `knw_level_code` = #{search.knwLevelCode}</if>",
            "<if test='search.knwIsLeaf != null'>AND `knw_is_leaf` = #{search.knwIsLeaf}</if>",
            "<if test='search.knwType != null'>AND `knw_type` = #{search.knwType}</if>",
            "<if test='search.knwSubject != null'>AND `knw_subject` = #{search.knwSubject}</if>",
            "<if test='search.subjectName != null'>AND `subject_name` = #{search.subjectName}</if>",
            "<if test='search.knwStage != null'>AND `knw_stage` = #{search.knwStage}</if>",
            "<if test='search.stageName != null'>AND `stage_name` = #{search.stageName}</if>",
            "<if test='search.knwAliasName != null'>AND `knw_alias_name` = #{search.knwAliasName}</if>",
            "<if test='search.knwTitleIndex != null'>AND `knw_title_index` = #{search.knwTitleIndex}</if>",
            "<if test='search.knwTreeType != null'>AND `knw_tree_type` = #{search.knwTreeType}</if>",
            "<if test='search.knwNamePinyin != null'>AND `knw_name_pinyin` = #{search.knwNamePinyin}</if>",
            "<if test='search.knwNameFullPinyin != null'>AND `knw_name_full_pinyin` = #{search.knwNameFullPinyin}</if>",
            "<if test='search.chooseType != null'>AND `choose_type` = #{search.chooseType}</if>",
            "<if test='search.remark != null'>AND `remark` = #{search.remark}</if>",
            "<if test='search.creator != null'>AND `creator` = #{search.creator}</if>",
            "<if test='search.creatorName != null'>AND `creator_name` = #{search.creatorName}</if>",
            "<if test='search.createTime != null'>AND `create_time` = #{search.createTime}</if>",
            "<if test='search.editor != null'>AND `editor` = #{search.editor}</if>",
            "<if test='search.editTime != null'>AND `edit_time` = #{search.editTime}</if>",
            "<if test='search.editorName != null'>AND `editor_name` = #{search.editorName}</if>",
            "<if test='search.flagUse != null'>AND `flag_use` = #{search.flagUse}</if>",
            "<if test='search.sysCode != null'>AND `sys_code` = #{search.sysCode}</if>",
            "</where>",
            "</script>"
    })
    Integer updateByExample(@Param("value") TkTbKnwtree value, @Param("search") TkTbKnwtree search);

    /**
     * 查找列表
     *
     * @param tkTbKnwtree tkTbKnwtree
     * @param page      page
     * @param orderBean orderBean
     * @return List<TkTbKnwtree>
     */
    @Select({"<script>",
            "SELECT",
            "`id` AS `id`,",
            "`knw_id` AS `knwId`,",
            "`knw_pid` AS `knwPid`,",
            "`knw_name` AS `knwName`,",
            "`knw_index` AS `knwIndex`,",
            "`knw_flow_id` AS `knwFlowId`,",
            "`knw_level` AS `knwLevel`,",
            "`knw_level_code` AS `knwLevelCode`,",
            "`knw_is_leaf` AS `knwIsLeaf`,",
            "`knw_type` AS `knwType`,",
            "`knw_subject` AS `knwSubject`,",
            "`subject_name` AS `subjectName`,",
            "`knw_stage` AS `knwStage`,",
            "`stage_name` AS `stageName`,",
            "`knw_alias_name` AS `knwAliasName`,",
            "`knw_title_index` AS `knwTitleIndex`,",
            "`knw_tree_type` AS `knwTreeType`,",
            "`knw_name_pinyin` AS `knwNamePinyin`,",
            "`knw_name_full_pinyin` AS `knwNameFullPinyin`,",
            "`choose_type` AS `chooseType`,",
            "`remark` AS `remark`,",
            "`creator` AS `creator`,",
            "`creator_name` AS `creatorName`,",
            "`create_time` AS `createTime`,",
            "`editor` AS `editor`,",
            "`edit_time` AS `editTime`,",
            "`editor_name` AS `editorName`,",
            "`flag_use` AS `flagUse`,",
            "`sys_code` AS `sysCode`",
            "FROM `tk_tb_knwtree`",
            "<where>",
            "<if test='tkTbKnwtree.id != null'>AND `id` = #{tkTbKnwtree.id}</if>",
            "<if test='tkTbKnwtree.knwId != null'>AND `knw_id` = #{tkTbKnwtree.knwId}</if>",
            "<if test='tkTbKnwtree.knwPid != null'>AND `knw_pid` = #{tkTbKnwtree.knwPid}</if>",
            "<if test='tkTbKnwtree.knwName != null'>AND `knw_name` = #{tkTbKnwtree.knwName}</if>",
            "<if test='tkTbKnwtree.knwIndex != null'>AND `knw_index` = #{tkTbKnwtree.knwIndex}</if>",
            "<if test='tkTbKnwtree.knwFlowId != null'>AND `knw_flow_id` = #{tkTbKnwtree.knwFlowId}</if>",
            "<if test='tkTbKnwtree.knwLevel != null'>AND `knw_level` = #{tkTbKnwtree.knwLevel}</if>",
            "<if test='tkTbKnwtree.knwLevelCode != null'>AND `knw_level_code` = #{tkTbKnwtree.knwLevelCode}</if>",
            "<if test='tkTbKnwtree.knwIsLeaf != null'>AND `knw_is_leaf` = #{tkTbKnwtree.knwIsLeaf}</if>",
            "<if test='tkTbKnwtree.knwType != null'>AND `knw_type` = #{tkTbKnwtree.knwType}</if>",
            "<if test='tkTbKnwtree.knwSubject != null'>AND `knw_subject` = #{tkTbKnwtree.knwSubject}</if>",
            "<if test='tkTbKnwtree.subjectName != null'>AND `subject_name` = #{tkTbKnwtree.subjectName}</if>",
            "<if test='tkTbKnwtree.knwStage != null'>AND `knw_stage` = #{tkTbKnwtree.knwStage}</if>",
            "<if test='tkTbKnwtree.stageName != null'>AND `stage_name` = #{tkTbKnwtree.stageName}</if>",
            "<if test='tkTbKnwtree.knwAliasName != null'>AND `knw_alias_name` = #{tkTbKnwtree.knwAliasName}</if>",
            "<if test='tkTbKnwtree.knwTitleIndex != null'>AND `knw_title_index` = #{tkTbKnwtree.knwTitleIndex}</if>",
            "<if test='tkTbKnwtree.knwTreeType != null'>AND `knw_tree_type` = #{tkTbKnwtree.knwTreeType}</if>",
            "<if test='tkTbKnwtree.knwNamePinyin != null'>AND `knw_name_pinyin` = #{tkTbKnwtree.knwNamePinyin}</if>",
            "<if test='tkTbKnwtree.knwNameFullPinyin != null'>AND `knw_name_full_pinyin` = #{tkTbKnwtree.knwNameFullPinyin}</if>",
            "<if test='tkTbKnwtree.chooseType != null'>AND `choose_type` = #{tkTbKnwtree.chooseType}</if>",
            "<if test='tkTbKnwtree.remark != null'>AND `remark` = #{tkTbKnwtree.remark}</if>",
            "<if test='tkTbKnwtree.creator != null'>AND `creator` = #{tkTbKnwtree.creator}</if>",
            "<if test='tkTbKnwtree.creatorName != null'>AND `creator_name` = #{tkTbKnwtree.creatorName}</if>",
            "<if test='tkTbKnwtree.createTime != null'>AND `create_time` = #{tkTbKnwtree.createTime}</if>",
            "<if test='tkTbKnwtree.editor != null'>AND `editor` = #{tkTbKnwtree.editor}</if>",
            "<if test='tkTbKnwtree.editTime != null'>AND `edit_time` = #{tkTbKnwtree.editTime}</if>",
            "<if test='tkTbKnwtree.editorName != null'>AND `editor_name` = #{tkTbKnwtree.editorName}</if>",
            "<if test='tkTbKnwtree.flagUse != null'>AND `flag_use` = #{tkTbKnwtree.flagUse}</if>",
            "<if test='tkTbKnwtree.sysCode != null'>AND `sys_code` = #{tkTbKnwtree.sysCode}</if>",
            "</where>",
            "${orderBean.orderSql}",
            "limit ${page.startPosition} ,${page.pageSize}",
            "</script>"
    })
    List<TkTbKnwtree> findByExample(@Param("tkTbKnwtree") TkTbKnwtree tkTbKnwtree, @Param("page") Page page, @Param("orderBean") OrderBean orderBean);

    /**
    * 查找列表总数
    *
    * @param tkTbKnwtree tkTbKnwtree
    * @return int
    */
    @Select({"<script>",
            "SELECT count(id)",
            "FROM `tk_tb_knwtree`",
            "<where>",
            "<if test='tkTbKnwtree.id != null'>AND `id` = #{tkTbKnwtree.id}</if>",
            "<if test='tkTbKnwtree.knwId != null'>AND `knw_id` = #{tkTbKnwtree.knwId}</if>",
            "<if test='tkTbKnwtree.knwPid != null'>AND `knw_pid` = #{tkTbKnwtree.knwPid}</if>",
            "<if test='tkTbKnwtree.knwName != null'>AND `knw_name` = #{tkTbKnwtree.knwName}</if>",
            "<if test='tkTbKnwtree.knwIndex != null'>AND `knw_index` = #{tkTbKnwtree.knwIndex}</if>",
            "<if test='tkTbKnwtree.knwFlowId != null'>AND `knw_flow_id` = #{tkTbKnwtree.knwFlowId}</if>",
            "<if test='tkTbKnwtree.knwLevel != null'>AND `knw_level` = #{tkTbKnwtree.knwLevel}</if>",
            "<if test='tkTbKnwtree.knwLevelCode != null'>AND `knw_level_code` = #{tkTbKnwtree.knwLevelCode}</if>",
            "<if test='tkTbKnwtree.knwIsLeaf != null'>AND `knw_is_leaf` = #{tkTbKnwtree.knwIsLeaf}</if>",
            "<if test='tkTbKnwtree.knwType != null'>AND `knw_type` = #{tkTbKnwtree.knwType}</if>",
            "<if test='tkTbKnwtree.knwSubject != null'>AND `knw_subject` = #{tkTbKnwtree.knwSubject}</if>",
            "<if test='tkTbKnwtree.subjectName != null'>AND `subject_name` = #{tkTbKnwtree.subjectName}</if>",
            "<if test='tkTbKnwtree.knwStage != null'>AND `knw_stage` = #{tkTbKnwtree.knwStage}</if>",
            "<if test='tkTbKnwtree.stageName != null'>AND `stage_name` = #{tkTbKnwtree.stageName}</if>",
            "<if test='tkTbKnwtree.knwAliasName != null'>AND `knw_alias_name` = #{tkTbKnwtree.knwAliasName}</if>",
            "<if test='tkTbKnwtree.knwTitleIndex != null'>AND `knw_title_index` = #{tkTbKnwtree.knwTitleIndex}</if>",
            "<if test='tkTbKnwtree.knwTreeType != null'>AND `knw_tree_type` = #{tkTbKnwtree.knwTreeType}</if>",
            "<if test='tkTbKnwtree.knwNamePinyin != null'>AND `knw_name_pinyin` = #{tkTbKnwtree.knwNamePinyin}</if>",
            "<if test='tkTbKnwtree.knwNameFullPinyin != null'>AND `knw_name_full_pinyin` = #{tkTbKnwtree.knwNameFullPinyin}</if>",
            "<if test='tkTbKnwtree.chooseType != null'>AND `choose_type` = #{tkTbKnwtree.chooseType}</if>",
            "<if test='tkTbKnwtree.remark != null'>AND `remark` = #{tkTbKnwtree.remark}</if>",
            "<if test='tkTbKnwtree.creator != null'>AND `creator` = #{tkTbKnwtree.creator}</if>",
            "<if test='tkTbKnwtree.creatorName != null'>AND `creator_name` = #{tkTbKnwtree.creatorName}</if>",
            "<if test='tkTbKnwtree.createTime != null'>AND `create_time` = #{tkTbKnwtree.createTime}</if>",
            "<if test='tkTbKnwtree.editor != null'>AND `editor` = #{tkTbKnwtree.editor}</if>",
            "<if test='tkTbKnwtree.editTime != null'>AND `edit_time` = #{tkTbKnwtree.editTime}</if>",
            "<if test='tkTbKnwtree.editorName != null'>AND `editor_name` = #{tkTbKnwtree.editorName}</if>",
            "<if test='tkTbKnwtree.flagUse != null'>AND `flag_use` = #{tkTbKnwtree.flagUse}</if>",
            "<if test='tkTbKnwtree.sysCode != null'>AND `sys_code` = #{tkTbKnwtree.sysCode}</if>",
            "</where>",
            "</script>"
    })
    int findByExampleCount(@Param("tkTbKnwtree") TkTbKnwtree tkTbKnwtree);

    /**
     * 根据id查找
     *
     * @param id id
     * @return TkTbKnwtree
     */
    @Select({"<script>",
            "SELECT",
            "`id` AS `id`,",
            "`knw_id` AS `knwId`,",
            "`knw_pid` AS `knwPid`,",
            "`knw_name` AS `knwName`,",
            "`knw_index` AS `knwIndex`,",
            "`knw_flow_id` AS `knwFlowId`,",
            "`knw_level` AS `knwLevel`,",
            "`knw_level_code` AS `knwLevelCode`,",
            "`knw_is_leaf` AS `knwIsLeaf`,",
            "`knw_type` AS `knwType`,",
            "`knw_subject` AS `knwSubject`,",
            "`subject_name` AS `subjectName`,",
            "`knw_stage` AS `knwStage`,",
            "`stage_name` AS `stageName`,",
            "`knw_alias_name` AS `knwAliasName`,",
            "`knw_title_index` AS `knwTitleIndex`,",
            "`knw_tree_type` AS `knwTreeType`,",
            "`knw_name_pinyin` AS `knwNamePinyin`,",
            "`knw_name_full_pinyin` AS `knwNameFullPinyin`,",
            "`choose_type` AS `chooseType`,",
            "`remark` AS `remark`,",
            "`creator` AS `creator`,",
            "`creator_name` AS `creatorName`,",
            "`create_time` AS `createTime`,",
            "`editor` AS `editor`,",
            "`edit_time` AS `editTime`,",
            "`editor_name` AS `editorName`,",
            "`flag_use` AS `flagUse`,",
            "`sys_code` AS `sysCode`",
            "FROM `tk_tb_knwtree`",
            "where id = #{id}",
            "</script>"
    })
    TkTbKnwtree findById(int id);

}