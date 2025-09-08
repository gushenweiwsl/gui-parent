package com.gui.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.hospital.mapper.HospitalDepartmentMapper;
import com.gui.hospital.mapper.HospitalMapper;
import com.gui.hospital.model.Hospital;
import com.gui.hospital.model.HospitalDepartment;
import com.gui.hospital.service.HospitalDepartmentService;
import com.gui.hospital.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HospitalDepartmentServiceImpl extends ServiceImpl<HospitalDepartmentMapper, HospitalDepartment> implements HospitalDepartmentService  {
    private final HospitalDepartmentMapper hospitalDepartmentMapper;

    @Override
    public List<HospitalDepartment> findByHospitalId(Integer hospitalId) {
        List<HospitalDepartment> list =  hospitalDepartmentMapper.findByHospitalId(hospitalId);
        return list;
    }
}
