package org.mysise.common.model;

import org.mysise.common.constant.Constant;
import org.mysise.common.exception.BaseException;

import java.io.Serializable;

/**
 * <p>
 *  返回前端数据处理
 * <p>
 *
 * @author fanwenjie
 * @since 2020/5/4 16:38
 */
public class Result<T> implements Serializable {

    private String code = Constant.SUCCESS;
    private String message;
    private T data;

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(BaseException baseCode){
        this.code=baseCode.getCode();
        this.message=baseCode.getMessage();
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
