package org.mysise.demo.rest;

import org.mysise.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @Autowired
    IDemoService iDemoService;


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
}
