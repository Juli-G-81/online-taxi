package com.juli.apipassenger.controller;

import com.juli.apipassenger.request.ShortMsgRequest;
import com.juli.apipassenger.service.VerificationCodeService;
import com.juli.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Juli
 * @date ： 2023/2/15 6:32 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */

@RestController
@RequestMapping("/verify-code")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/send")
    public ResponseResult send(@RequestBody @Validated ShortMsgRequest request){
        return verificationCodeService.send(request.getPhoneNumber());
    }
}
