package org.mysise.demo1.service.impl;

import org.mysise.common.model.Result;
import org.mysise.demo.feign.IDemoClient;
import org.mysise.demo1.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class Demo1ServiceImpl implements Demo1Service {


    @Autowired
    IDemoClient IDemoClient;


    @Override
    public Result<String> rpcdemoTest() {
        return IDemoClient.hello();
    }
}
