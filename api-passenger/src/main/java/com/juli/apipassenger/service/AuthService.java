package com.juli.apipassenger.service;

import com.juli.internalcommon.dto.ResponseResult;

public interface AuthService {
    public ResponseResult auth(String passengerPhone, String code);

}