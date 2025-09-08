package com.gui.hospital;

/**
 *
  根据医院id查询一级科室
   根据一级科室查询二级科室
   pid=0就是一级科室
 *
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.gui.hospital.mapper")
@EnableAsync
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
}
