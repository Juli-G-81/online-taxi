package com.juli.serviceverificationcode.controller;

import com.juli.internalcommon.dto.ResponseResult;
import com.juli.serviceverificationcode.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Juli
 * @date ： 2023/2/10 2:33 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerifyCodeController {

    @Autowired
    VerifyCodeService verifyCodeService;

    @GetMapping("/generate/{identity}/{phoneNum}")
    public ResponseResult generate(@PathVariable("identity") int identity, @PathVariable("phoneNum") String phoneNum){

        return verifyCodeService.generate(identity, phoneNum);
    }

}
