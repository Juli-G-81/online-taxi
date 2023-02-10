package com.juli.internalcommon.dto.serviceverificationcode;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ：Juli
 * @date ： 2023/2/10 2:59 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Data
@Getter
@Setter
public class VerifyCodeResponse {
    public String code;

    public VerifyCodeResponse(String code){
        this.code = code;
    }
}
