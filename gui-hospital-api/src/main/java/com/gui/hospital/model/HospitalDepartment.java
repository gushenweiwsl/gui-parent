package com.gui.hospital.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 医院科室实体类
 */
@TableName("tb_hospital_department")
@Data
public class HospitalDepartment implements Serializable {


    @TableId(type = IdType.AUTO)
    private Integer id;//主键
    private String name;//科室名称
    private Integer pid;//父级id 如果是0是 说明是一级科室
    private Integer hospitalId;//这个科室所在医院的id
    private String introduce;//科室介绍

    @TableLogic(value = "1",delval = "0")
    private Integer isDelete;

    // 数据库排除这个字段
    @TableField(exist = false)
    private List<HospitalDepartment> children;//子级科室



}
