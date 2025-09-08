package com.gui.hospital.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.hospital.mapper.DoctorMapper;
import com.gui.hospital.model.Doctor;
import com.gui.hospital.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
    private final DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findByHdId(String hdId,String dayTime) {
        Date currentDate = null;
        if (dayTime == null) {
            // 获取当前日期（不包含时间）
            LocalDate localDate = LocalDate.now();
            // 转换为 Date 类型（时间部分为 00:00:00）
            currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                currentDate = simpleDateFormat.parse(dayTime);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            //currentDate = Date.from(LocalDate.parse(dayTime).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        List<Doctor> list =  doctorMapper.findByHdId(hdId,currentDate);
        return list;
    }
}
