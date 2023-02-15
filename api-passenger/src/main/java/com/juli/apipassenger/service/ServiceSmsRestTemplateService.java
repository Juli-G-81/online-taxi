package com.juli.apipassenger.service;

import com.juli.internalcommon.dto.ResponseResult;

public interface ServiceSmsRestTemplateService {
    public ResponseResult sendSms(String phoneNumber , String code);

}
