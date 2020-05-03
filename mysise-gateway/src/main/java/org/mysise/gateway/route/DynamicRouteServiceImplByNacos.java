package org.mysise.gateway.route;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * <p>
 *  Nacos 实现
 * <p>
 *
 * @author fanwenjie
 * @since 2020/5/2 11:47
 */
@Component
@Slf4j
public class DynamicRouteServiceImplByNacos {


    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    public DynamicRouteServiceImplByNacos() {

        dynamicRouteByNacosListener("mysise-gateway-route","DEFAULT_GROUP");
    }

    /**
     * 监听Nacos Server下发的动态路由配置
     * @param dataId
     * @param group
     */
    public void dynamicRouteByNacosListener(String dataId, String group){
        try {
            ConfigService configService= NacosFactory.createConfigService("bt.mysise.org:8848");
            String content = configService.getConfig(dataId, group, 5000);
            configService.publishConfig(dataId,group,content);
            log.info("路由信息：{}", content);
            configService.addListener(dataId, group, new Listener()  {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    List<RouteDefinition> definitionList= JSON.parseArray(configInfo,RouteDefinition.class);
                    definitionList.forEach((definition)->{
                        log.info("update route: [{}]", JSON.toJSONString(definition));
                        dynamicRouteService.update(definition);
                    });
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            log.error("gateway 路由刷新异常 ：{}",e.getErrMsg());
        }
    }
}
