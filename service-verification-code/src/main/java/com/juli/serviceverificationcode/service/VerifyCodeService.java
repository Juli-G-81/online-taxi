package com.juli.serviceverificationcode.service;

import com.juli.internalcommon.dto.ResponseResult;
import com.juli.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;

public interface VerifyCodeService {

    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNum);
}
