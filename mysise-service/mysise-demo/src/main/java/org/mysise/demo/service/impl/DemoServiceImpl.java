package org.mysise.demo.service.impl;

import org.mysise.demo.service.IDemoService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;


/**
 * <p>
 *  demo 实现类
 * <p>
 *
 * @author fanwenjie
 * @since 2020/4/30 23:17
 */
@Service
public class DemoServiceImpl implements IDemoService {

    AtomicLong id = new AtomicLong(1);

    @Override
    public String hello() {

        return "hello demo" + id.incrementAndGet();
    }
}
