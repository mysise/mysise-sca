package org.mysise.authentication.nacosconfig;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;


@Component
public class SampleRunners implements ApplicationRunner {

    @Value("${user.name}")
    String userName;

    @Value("${user.age:25}")
    int userAge;

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(
                String.format("Initial username=%s, userAge=%d", userName, userAge));

        nacosConfigProperties.configServiceInstance().addListener(
                "nacos-config-example.properties", "DEFAULT_GROUP", new Listener() {

                    /**
                     * Callback with latest config data.
                     *
                     * For example, config data in Nacos is:
                     *
                     * user.name=Nacos user.age=25
                     *
                     * @param configInfo latest config data for specific dataId in Nacos
                     *     server
                     */
                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        Properties properties = new Properties();
                        try {
                            properties.load(new StringReader(configInfo));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("config changed: " + properties);
                    }

                    @Override
                    public Executor getExecutor() {
                        return null;
                    }
                });
    }
}

