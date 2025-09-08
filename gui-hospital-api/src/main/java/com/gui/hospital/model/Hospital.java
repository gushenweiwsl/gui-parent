package com.gui.hospital.model;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 医院实体类
 *
 * 条件+分页查询
 *
 * 根据中文名称模糊查询
 * 根据地理位置模糊查询
 * 根据医院等级查询
 * 根据医保定点
 *
 */
@TableName("tb_hospital")
@Data // 提供 get/set 方法
public class Hospital implements Serializable {

    // 设置id为自增长
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 因为数据库是下换线命名,所以这里使用@Column注解
    /*@Column(name = "chinese_name")*/
    private String chineseName;
    private String englishName;
    private Date creationTime;
    private String address; //地理位置
    private String manageDept;//主管部门
    private String dean;//院长
    private String hospitalLevel; // 等级医院管理将医院分成一、二、三级，一、二级医院分别分为甲、乙、丙三等，三级医院分为特、甲、乙、丙四等
    private String hospitalCategory;
    private Integer isInsurance;//医保定点 1 是 2 不是
    private String economicType;//类型
    private String introduce;//医院介绍
    // 逻辑删除
    @TableLogic(delval = "0",value = "1")
    private Integer isDelete; //是否删除
    private String area; // 医院区域

    // 这个医院的一级科室

    // 如果数据库没有这个 查询的时候 需要排除这个属性
    @TableField(exist = false)
    private List<HospitalDepartment> departmentList;



}
