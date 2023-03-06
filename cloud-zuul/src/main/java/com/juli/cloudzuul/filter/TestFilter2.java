package com.juli.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * @author ：Juli
 * @date ： 2023/3/6 7:58 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Component
public class TestFilter2 extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("在TestFilter2 的should");
        return RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("TestFilter2 执行了");
        return null;
    }
}
