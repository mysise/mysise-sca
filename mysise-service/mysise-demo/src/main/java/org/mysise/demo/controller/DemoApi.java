package org.mysise.demo.controller;

import org.mysise.demo.entity.IndexTest;
import org.mysise.demo.service.IDemoService;
import org.mysise.demo.service.IIndexTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  
 * <p>
 *
 * @author fanwenjie
 * @since 2020/5/1 9:36
 */
@RestController
public class DemoApi {

    AtomicInteger integer = new AtomicInteger();

    @Autowired
    IDemoService iDemoService;

    @Autowired
    IIndexTestService iIndexTestService;

    /**
     * <p>
     *  hello
     * <p>
     *
     * @author fanwenjie
     * @since 2020/5/1 9:37
     */
    @GetMapping("/hello")
    public String hello(){
        return iDemoService.hello();
    }


    @GetMapping("/hi")
    public List<IndexTest> hi(){
        List<IndexTest> result = iIndexTestService.list();
        return result;
//        return "hi:" + integer.getAndIncrement();
    }
}
