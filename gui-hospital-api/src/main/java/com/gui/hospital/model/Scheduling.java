
package com.gui.hospital.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 
* @TableName tb_scheduling
*/
@TableName("tb_scheduling")
@Data

public class Scheduling implements Serializable {

    /**
    * 排班id
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 排班日期
    */
    private Date dayTime;
    /**
    * 时间段落比如:{[8:30,11:30],[14:00,17:00]}
    */

    private String dateSection;
    /**
    * 剩余挂号数量
    */
    private Integer residualQuantity;
    /**
    * 线上挂号量 (上下午)
    */
    private Integer onLineCount;
    /**
    * 医生id
    */
    private Integer doctorId;
    /**
    * 科室id
    */
    private Integer hdId;
    /**
    * 1 未启用 2 启用 3 作废
    */
    private Integer status;
    /**
    * 0删除 1 正常
    */
    @TableLogic(value = "1",delval = "0")
    private Integer isDelete;


}
