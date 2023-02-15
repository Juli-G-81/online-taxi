package com.juli.internalcommon.dto.servicesms;

import lombok.Data;

import java.util.Map;

/**
 * @author ：Juli
 * @date ： 2023/2/15 5:59 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Data
public class SmsTemplateDto {

    // 模板id
    private String id;

    // 参数  占位符
    private Map<String, Object> templateMap;

    @Override
    public String toString() {
        return "SmsTemplateDto [id=" + id + ", templateMap=" + templateMap + "]";
    }
}
