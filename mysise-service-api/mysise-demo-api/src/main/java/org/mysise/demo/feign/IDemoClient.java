package org.mysise.demo.feign;


import org.mysise.common.model.Result;
import org.mysise.demo.feign.fall.IDemoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * <p>
 *  demo feign 调用
 * <p>
 *
 * @author fanwenjie
 * @since 2020/4/30 23:12
 */
@FeignClient(value = "mysise-demo", fallback = IDemoClientFallback.class)
public interface IDemoClient {

    String prefix = "/demo";
    String HELLO = prefix + "/hello";

    @GetMapping(value = HELLO)
    Result<String> hello();
}
