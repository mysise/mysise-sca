package org.mysise.gateway.route.modle;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *  路由断言定义模型
 * <p>
 *
 * @author fanwenjie
 * @since 2020/5/2 1:04
 */
public class GatewayPredicateDefinition {

    /**
     * <p>
     *  断言对应的Name
     * <p>
     *
     * @since 2020/5/2 1:04
     */
    private String name;
    /**
     * <p>
     *  配置的断言规则
     * <p>
     *
     * @since 2020/5/2 1:04
     */
    private Map<String, String> args = new LinkedHashMap<>();
}
