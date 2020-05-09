package org.mysise.demo1.rest;

import org.mysise.common.model.Result;
import org.mysise.demo.feign.IDemoClient;
import org.mysise.demo1.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class Demo1Api {

    AtomicInteger id = new AtomicInteger(1);
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
    public Result<String> test(){
        Result<String> result = restTemplate.getForObject("http://mysise-demo/demo/hello",Result.class);
        Result<String> result1 =  IDemoClient.hello();
        return result1;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello demo1 : " + id.getAndDecrement();
    }
}
