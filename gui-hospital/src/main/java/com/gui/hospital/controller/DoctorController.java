package com.gui.hospital.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.gui.hospital.model.Doctor;
import com.gui.hospital.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("findByHdId")
    public R findByHdId(String hdId,@RequestParam(required = false) String dayTime){
        List<Doctor> list =  doctorService.findByHdId(hdId,dayTime);
        return R.ok(list);
    }
}
