package com.juli.apipassenger.gray;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author ：Juli
 * @date ： 2023/3/2 3:57 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class GrayRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    //选服务
    public Server choose(ILoadBalancer lb, Object key) {
        System.out.println("灰度 rule");
        Server server = null;
        while(server == null){
            // 从eureka注册列表中拿服务列表
            List<Server> reachableServers = lb.getReachableServers();
            // 从Threadlocal变量中拿信息
            Map<String, String> map = RibbonParameters.get();
            String version = "";
            if(null != map && map.containsKey("version")){
                // 用户的version
                version = map.get("version");
            }
            for(int i=0;i<reachableServers.size();i++){
                DiscoveryEnabledServer server2 = (DiscoveryEnabledServer)reachableServers.get(i);
                Map<String, String> metadata = server2.getInstanceInfo().getMetadata();
                // 从服务的metadata里面获取的
                String version1 = metadata.get("version");
                // 如果theadlocal中拿到的跟eureka服务中设置的metadata-map中的version一致，就选取此服务
                if(null != version && version1 != null && version.trim().equals(version1.trim())){
                    server = server2;
                }
            }
            // 没匹配到会默认走最后一个，因此：
            // 如果没有匹配的服务，就随机取一个，相当于是RandomRule
            if(null == server){
                int i = new Random().nextInt(reachableServers.size());
                System.out.println("GrayRule i="+i);
                server = reachableServers.get(i);
            }
        }
        return server;
    }
}
