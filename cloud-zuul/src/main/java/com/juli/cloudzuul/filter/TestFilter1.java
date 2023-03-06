package com.juli.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author ：Juli
 * @date ： 2023/3/6 7:57 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Component
public class TestFilter1 extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("TestFilter1 执行了");
        RequestContext.getCurrentContext().setSendZuulResponse(false);
        return null;
    }
}
