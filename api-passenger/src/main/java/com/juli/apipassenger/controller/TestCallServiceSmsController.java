package com.juli.apipassenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：Juli
 * @date ： 2023/2/15 6:33 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestCallServiceSmsController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public String testCall() {

        return restTemplate.getForObject("http://service-sms/test/sms-test", String.class);
    }

    @GetMapping("/test")
    public String testCall1() {

        return "api-passenger";
    }
}
