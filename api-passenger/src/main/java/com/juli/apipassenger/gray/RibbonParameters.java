package com.juli.apipassenger.gray;

import org.springframework.stereotype.Component;

/**
 * @author ：Juli
 * @date ： 2023/3/2 3:58 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Component
public class RibbonParameters {

    private static final ThreadLocal local = new ThreadLocal();

    // get
    public static <T> T get(){
        return  (T)local.get();
    }

    // set
    public static <T> void set(T t){
        local.set(t);
    }
}