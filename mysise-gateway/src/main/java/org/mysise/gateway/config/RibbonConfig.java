package org.mysise.gateway.config;

import com.netflix.loadbalancer.IRule;
import org.mysise.gateway.route.NacosWeightRandomRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *  开启Nacos 权重方式负载均衡
 * <p>
 *
 * @author FanWenJie
 * @since 2020/5/8 12:42
 */
@Configuration
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new NacosWeightRandomRole();
    }
}
