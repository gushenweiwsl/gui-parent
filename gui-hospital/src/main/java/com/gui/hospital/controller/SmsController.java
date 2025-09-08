package com.gui.hospital.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.gui.hospital.service.SmsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@AllArgsConstructor
public class SmsController {
    private final SmsService smsService;

    // 向多个用户发送短信
    @PostMapping("/send")
    public R sendSms(@RequestBody String[] phones) {
        for (String phone : phones) {
            smsService.sendSms(phone);
        }
        return R.ok("短信发送中.....");
    }

}
