package com.juli.apipassenger.service.impl;

import com.juli.apipassenger.service.ServicePassengerUserService;
import com.juli.internalcommon.dto.ResponseResult;
import com.juli.internalcommon.dto.servicepassengeruser.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：Juli
 * @date ： 2023/2/15 5:41 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Service
public class ServicePassengerUserServiceImpl implements ServicePassengerUserService {

    @Autowired
    public RestTemplate restTemplate;
    // RestTemplate是一个同步的web http客户端请求模板工具, 是基于spring框架的底层的一个知识点

    @Override
    public ResponseResult login(String passengerPhone) {
        String url = "http://service-passenger-user/auth/login";

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassengerPhone(passengerPhone);
        ResponseResult result = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<Object>(loginRequest, null), ResponseResult.class).getBody();

        return result;
    }
}
