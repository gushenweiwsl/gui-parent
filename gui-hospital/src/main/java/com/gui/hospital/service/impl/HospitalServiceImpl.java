package com.gui.hospital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.common.PageInfo;
import com.gui.hospital.mapper.HospitalMapper;
import com.gui.hospital.model.Hospital;
import com.gui.hospital.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 线程池
 * spring cloud alibaba
 *
 */
@Service
@AllArgsConstructor
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService {

    private final HospitalMapper hospitalMapper;
    @Override
    public PageInfo search(PageInfo<Hospital> pageInfo) {
        Page<Hospital> page = new Page<>(pageInfo.getCurrentPage(), pageInfo.getPageSize());

        QueryWrapper<Hospital> wrapper = new QueryWrapper<>();
        Hospital query = pageInfo.getQuery();

        if (query != null) {
            // 根据等级查询
            if (query.getHospitalLevel() != null && !query.getHospitalLevel().equals("")) { // 医院等级
                wrapper.lambda().eq(Hospital::getHospitalLevel, query.getHospitalLevel());
            }
            // 根据医院的中文名称查询
            if (query.getChineseName() != null && !query.getChineseName().equals("")) { // 医院名称
                wrapper.lambda().like(Hospital::getChineseName, query.getChineseName());
            }
            // 根据区域查询
            if (query.getArea() != null && !query.getArea().equals("")) { // 医院区域
                wrapper.lambda().eq(Hospital::getArea, query.getArea());
            }

        }
        String sortField = pageInfo.getSortField();
        if (sortField != null && !sortField.equals("")){
            if ("ASC".equalsIgnoreCase(pageInfo.getSortType())){
                // 根据等级进行降序
                wrapper.orderBy(true,true, pageInfo.getSortField());
            }else {
                wrapper.orderBy(true,false, pageInfo.getSortField());
            }
        }


        Page<Hospital> hospitalPage = hospitalMapper.selectPage(page, wrapper);
        pageInfo.setTotal( (int) hospitalPage.getTotal());
        pageInfo.setList(hospitalPage.getRecords());

        return pageInfo;
    }
    private final RedisTemplate redisTemplate;

    @Override
    public List<Hospital> findByName(String name) {
        QueryWrapper<Hospital> hospitalQueryWrapper = new QueryWrapper<>();

        if (name != null && !name.equals("")) {
            hospitalQueryWrapper.lambda().like(Hospital::getChineseName, name);
            List<Hospital> hospitalList = hospitalMapper.selectList(hospitalQueryWrapper);
            return hospitalList;
        }else {


            // 先查询缓存中是否存在数据
            Object o = redisTemplate.boundValueOps("hospitalList").get();
            if (o != null){
                return (List<Hospital>) o;
            }else {
                // 如果没有数据，则从数据库中查询
                List<Hospital> hospitalList = hospitalMapper.selectList(hospitalQueryWrapper);
                // 同步到缓存中
                redisTemplate.boundValueOps("hospitalList").set(hospitalList);
                // 返回查询结果
                return hospitalList;
            }

        }

    }
}
