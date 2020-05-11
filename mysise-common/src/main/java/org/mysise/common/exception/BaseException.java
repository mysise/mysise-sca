package org.mysise.common.exception;

/**
 * <p>
 *  基础错误出口类
 * <p>
 *
 * @author fanwenjie@mysise.org
 * @since 2020/5/11 22:04
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
