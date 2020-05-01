package org.mysise.demo1.rest;

import org.mysise.demo.feign.IDemoClient;
import org.mysise.demo1.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Demo1Api {

    @Autowired
    Demo1Service demo1Service;

    @Autowired
    IDemoClient IDemoClient;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/test")
    String rpctest(String name){
//        String resut = restTemplate.getForObject("http://mysise-demo/demo/hello",String.class);

        return IDemoClient.hello();
    }
}
