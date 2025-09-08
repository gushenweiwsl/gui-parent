package com.gui.hospital.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gui.common.PageInfo;
import com.gui.hospital.model.Hospital;
import com.gui.hospital.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hospital")
@RestController
@AllArgsConstructor
// @Api("医院管理")
public class HospitalController {
    private final HospitalService hospitalService;
    /**
     *  页大小、当前页、查询条件、排序类型、排序字段
     * @return
     */
    // @ApiOperation(value = "医院分页查询",notes = "医院分页查询",httpMethod = "POST", produces = "application/json")
    @PostMapping("search")
    public R search( @RequestBody PageInfo<Hospital> pageInfo){
        PageInfo page =  hospitalService.search(pageInfo);
        return R.ok(page);
    }
    @GetMapping
    public R findByName(@RequestParam(required = false) String name){
        List<Hospital> hospitals =  hospitalService.findByName(name);
        return R.ok(hospitals);
    }

}
