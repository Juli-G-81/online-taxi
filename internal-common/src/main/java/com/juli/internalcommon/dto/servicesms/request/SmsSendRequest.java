package com.juli.internalcommon.dto.servicesms.request;

import com.juli.internalcommon.dto.servicesms.SmsTemplateDto;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：Juli
 * @date ： 2023/2/15 6:01 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Data
public class SmsSendRequest {


    private String[] receivers;
    private List<SmsTemplateDto> data;

    @Override
    public String toString() {
        return "SmsSendRequest [reveivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
    }

}
