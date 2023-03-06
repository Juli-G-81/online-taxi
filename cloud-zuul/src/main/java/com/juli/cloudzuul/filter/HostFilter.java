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
 * @date ： 2023/3/6 5:12 PM
 * @description： 如果在系统当中只知道新地址
 * @modifiedBy ：
 * @version:
 */
public class HostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 5;
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
        if (remoteAddr.contains("/zuul-api-driver")){
            // 服务
            currentContext.set(FilterConstants.SERVICE_ID_KEY,"service-sms");
            // currentContext.set(FilterConstants.REQUEST_URI_KEY,"/test/sms-test3");
            try {
                currentContext.setRouteHost(new URI("http://localhost:8003/test/sms-test3").toURL());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }


        }


        return null;
    }
}
