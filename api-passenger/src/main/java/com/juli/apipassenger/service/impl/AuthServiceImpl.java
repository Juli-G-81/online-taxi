package com.juli.apipassenger.service.impl;

import com.juli.apipassenger.service.AuthService;
import com.juli.apipassenger.service.ServicePassengerUserService;
import com.juli.apipassenger.service.ServiceVerificationCodeRestTemplateService;
import com.juli.internalcommon.constant.CommonStatusEnum;
import com.juli.internalcommon.constant.IdentityConstant;
import com.juli.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Juli
 * @date ： 2023/2/15 6:29 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Service
public class AuthServiceImpl implements AuthService {


    @Autowired
    private ServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private ServicePassengerUserService servicePassengerUserService;

    @Override
    public ResponseResult auth(String passengerPhone, String code) {
        // 验证验证码：
        ResponseResult responseResult = serviceVerificationCodeRestTemplateService.verifyCode(IdentityConstant.PASSENGER,passengerPhone,code);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("登录失败：验证码校验失败");
        }

        // 用户登录
        responseResult = servicePassengerUserService.login(passengerPhone);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("登录失败：登录失败");
        }

        return responseResult;
    }
}
