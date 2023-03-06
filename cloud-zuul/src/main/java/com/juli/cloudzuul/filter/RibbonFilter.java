package com.juli.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author ：Juli
 * @date ： 2023/3/6 5:30 PM
 * @description： 同一个服务中的地址不一致的情况
 * @modifiedBy ：
 * @version:
 */
public class RibbonFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        // 获取请求URL
        String remoteAddr = request.getRequestURI();

        if (remoteAddr.contains("/sms-test31")){
            // 服务
            currentContext.set(FilterConstants.SERVICE_ID_KEY,"service-sms");
             currentContext.set(FilterConstants.REQUEST_URI_KEY,"/test/sms-test3");



        }


        return null;
    }
}
