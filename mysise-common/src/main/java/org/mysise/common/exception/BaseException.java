package org.mysise.common.exception;

/**
 * <p>
 *  基础错误出口类
 * <p>
 *
 * @author FanWenJie
 * @since 2020/5/4 18:45
 */
public interface BaseException {

    /**
     *  获取错误码
     */
    String getCode();

    /**
     *  获取错误信息
     */
    String getMessage();
}
