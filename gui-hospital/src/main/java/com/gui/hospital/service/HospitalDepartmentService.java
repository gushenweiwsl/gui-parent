package com.gui.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.hospital.model.Hospital;
import com.gui.hospital.model.HospitalDepartment;

import java.util.List;

public interface HospitalDepartmentService extends IService<HospitalDepartment> {
    /**
     * 根据医院id查询科室列表
     * @param hospitalId
     * @return
     */
    List<HospitalDepartment> findByHospitalId(Integer hospitalId);
}
