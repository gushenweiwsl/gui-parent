package com.gui.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.hospital.model.Doctor;

import java.util.List;

public interface DoctorService extends IService<Doctor> {
    List<Doctor> findByHdId(String hdId,String dayTime);
}
