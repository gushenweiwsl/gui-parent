package com.gui.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.hospital.model.Hospital;
import com.gui.hospital.model.HospitalDepartment;

import java.util.List;

public interface HospitalDepartmentMapper extends BaseMapper<HospitalDepartment> {

    /**
     * 根据医院id查询科室
     * @param hospitalId
     * @return
     */
    List<HospitalDepartment> findByHospitalId(Integer hospitalId);
}
