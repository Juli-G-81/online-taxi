package com.juli.apipassenger.gray;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @author ：Juli
 * @date ： 2023/3/2 4:07 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class GrayRibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new GrayRule();
    }

}
