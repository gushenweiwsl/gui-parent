package com.gui.hospital.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 【请填写功能名称】对象 number_source
 * 
 * @date 2024-06-05
 */
@Data
@TableName("tb_number_source")
public class NumberSource implements Serializable {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 排班id */
    private Long schedulingId;

    /** 预计就诊时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date predictClinicTime;

    /** 序号 */
    private Long serialNumber;

    /** 0 删除 1 正常 */
    @TableLogic(value = "1" ,delval = "0")
    private Long isDelete;

    /** 状态 0 不占用 1 占用 */
    private Long status;

    private Integer doctorId;
}
