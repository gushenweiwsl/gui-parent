package com.gui.hospital.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.gui.hospital.model.HospitalDepartment;
import com.gui.hospital.service.HospitalDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospitalDepartment")
@AllArgsConstructor
public class HospitalDepartmentController {
    private final HospitalDepartmentService hospitalDepartmentService;


    @GetMapping("/list")
    public R list(Integer hospitalId){
        List<HospitalDepartment> list =  hospitalDepartmentService.findByHospitalId(hospitalId);
        return R.ok(list);
    }



}
