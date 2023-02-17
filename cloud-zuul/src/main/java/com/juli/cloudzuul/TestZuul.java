package com.juli.cloudzuul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Juli
 * @date ： 2023/2/17 11:39 AM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@RestController
public class TestZuul {

    @GetMapping("/my-zuul")
    public String testController(){
        System.out.println("我的调用！");

        return "my zuul";
    }
}

