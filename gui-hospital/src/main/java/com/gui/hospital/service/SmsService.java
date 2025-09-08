package com.gui.hospital.service;

public interface SmsService {
    /**
     * 发送短信
     * @param phones
     */
    void sendSms(String phone);
}
