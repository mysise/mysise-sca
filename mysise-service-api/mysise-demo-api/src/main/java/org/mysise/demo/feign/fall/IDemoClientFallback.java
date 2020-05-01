package org.mysise.demo.feign.fall;

import org.mysise.demo.feign.IDemoClient;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  
 * <p>
 *
 * @author fanwenjie
 * @since 2020/5/1 12:04
 */
@Component
public class IDemoClientFallback implements IDemoClient {


    public String hello() {
        return "调用失败";
    }
}
