package org.mysise.demo.feign;

import org.mysise.common.model.Result;
import org.mysise.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoClient implements IDemoClient {


    @Autowired
    private IDemoService iDemoService;


    @Override
    @GetMapping(value = HELLO)
    public Result<String> hello() {
        return new Result<>(iDemoService.hello());
    }
}
