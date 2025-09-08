package com.gui.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.hospital.model.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DoctorMapper extends BaseMapper<Doctor> {
    List<Doctor> findByHdId(@Param("hdId") String hdId, @Param("dayTime") Date dayTime);
}
