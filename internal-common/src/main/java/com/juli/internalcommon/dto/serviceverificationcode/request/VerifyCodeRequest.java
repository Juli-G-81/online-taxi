package com.juli.internalcommon.dto.serviceverificationcode.request;

import lombok.Data;

/**
 * @author ：Juli
 * @date ： 2023/2/15 6:14 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Data
public class VerifyCodeRequest {

    private int identity;

    private String phoneNumber;

    private String code;
}
