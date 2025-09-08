package com.gui.hospital.service.impl;

import com.gui.hospital.service.SmsService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {
    @Async("smsThreadPool")
    @Override
    public void sendSms(String phone) {
        try {
            System.out.println("发送短信给：" + phone+"当前线程："+Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println( phone+": 发送成功！！！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
