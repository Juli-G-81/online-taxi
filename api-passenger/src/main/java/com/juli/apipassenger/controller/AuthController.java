package com.juli.apipassenger.controller;

import com.juli.apipassenger.request.UserAuthRequest;
import com.juli.apipassenger.service.AuthService;
import com.juli.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Juli
 * @date ： 2023/2/15 6:31 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Validated UserAuthRequest userAuthRequest) {

        String passengerPhone = userAuthRequest.getPassengerPhone();
        String code = userAuthRequest.getCode();

        return authService.auth(passengerPhone , code);

    }
}
