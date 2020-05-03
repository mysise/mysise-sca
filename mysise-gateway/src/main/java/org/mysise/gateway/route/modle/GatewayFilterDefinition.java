package org.mysise.gateway.route.modle;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *  过滤器定义模型
 * <p>
 *
 * @author fanwenjie
 * @since 2020/5/2 1:03
 */
@Data
public class GatewayFilterDefinition {
    /**
     * <p>
     *  Filter Name
     * <p>
     *
     * @since 2020/5/2 1:05
     */
    private String name;
    /**
     * <p>
     *  对应的路由规则
     * <p>
     *
     * @since 2020/5/2 1:05
     */
    private Map<String, String> args = new LinkedHashMap<>();
}
