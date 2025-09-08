package com.gui.hospital.model;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *  tb_doctor
 * 
 */
@Data
@TableName("tb_doctor")
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 姓名 */
    private String name;

    /** 医院的id */
    private Long hospitalId;

    /** 类型 */
    private String type;

    /** 擅长 */
    private String beGoodAt;

    /** 简介 */
    private String introduce;

    /** 所属科室 */
    private Long hospitalDepartmentId;

    /** 性别 0 女 1 男 */
    private Long sex;

    /** 是否删除0 删除 1正常 */
    @TableLogic(value = "1" ,delval = "0")
    private Long isDelete;

    // 查询这个表的时候排除这个字段 ，因为不是这个表中的字段 ，是关联查询的
    // 用于一对一的关联关系
    @TableField(exist = false)
    private Scheduling scheduling;



}
