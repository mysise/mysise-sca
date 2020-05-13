package org.mysise.demo.feign.fall;

import org.mysise.common.model.Result;
import org.mysise.demo.feign.IDemoClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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


    @Override
    public Result<String> hello() {
        return new Result<>("调用失败");
    }
}
