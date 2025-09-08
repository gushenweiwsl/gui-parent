package com.gui.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.common.PageInfo;
import com.gui.hospital.model.Hospital;

import java.util.List;

public interface HospitalService extends IService<Hospital> {
    PageInfo search(PageInfo<Hospital> pageInfo);

    /**
     * 根据医院名称查询
     * @param name
     * @return
     */
    List<Hospital> findByName(String name);
}
