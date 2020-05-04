package org.mysise.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mysise.common.constant.Constant;
import org.mysise.common.exception.BaseException;
import org.mysise.common.exception.CommonCode;

import java.io.Serializable;

/**
 * <p>
 *  返回前端数据处理
 * <p>
 *
 * @author fanwenjie
 * @since 2020/5/4 16:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    String code = Constant.SUCCESS;
    String message;
    T data;

    public static Result<Object> success(Object data){
        return new Result<Object>(data);
    }

    public static Result<CommonCode> fail(String code, String message){
        return new Result<CommonCode>(code,message);
    }

    public static Result<CommonCode> fail(BaseException baseCode){
        return new Result<CommonCode>(baseCode);
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
}
