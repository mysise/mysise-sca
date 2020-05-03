package org.mysise.demo1.rest;

import org.mysise.demo.feign.IDemoClient;
import org.mysise.demo1.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class Demo1Api {

    AtomicInteger id = new AtomicInteger(1);
    @Autowired
    Demo1Service demo1Service;

    @Autowired
    IDemoClient IDemoClient;



    @GetMapping("/test")
    String rpctest(String name){
        return IDemoClient.hello();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello demo1 : " + id.getAndDecrement();
    }
}
