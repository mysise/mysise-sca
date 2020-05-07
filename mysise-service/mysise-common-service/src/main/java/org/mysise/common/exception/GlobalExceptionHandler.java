package org.mysise.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mysise.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  全局异常
 * <p>
 * @author fanwenjie@cvte.com
 * @sine  oversea v1.0.0 2019/11/14 7:10 下午
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {


    @Autowired
    private ObjectMapper objectMapper;

    /**
     * <p>
     *  业务异常
     * <p>
     *
     * @author FanWenJie
     * @since 2020/5/4 17:45
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Result<CommonCode> bizExceptionHandler(HttpServletRequest req, BizException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return new Result<CommonCode>(e.getErrorCode(),e.getErrorMsg());
    }




    /**
     * <p>
     *  数据库异常
     * <p>
     * @author fanwenjie@cvte.com
     * @sine  oversea v1.0.0 2019/12/10 10:48 上午
     */
    @ExceptionHandler(value =SqlException.class)
    @ResponseBody
    public Result<CommonCode> sqlExceptionHandler(HttpServletRequest req, SqlException e){
        log.error("未知异常！原因是:",e);
        return new Result<CommonCode>(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * <p>
     * 404
     * <p>
     *
     * @author FanWenJie
     * @since 2020/5/7 15:46
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Result<CommonCode> handler(NoHandlerFoundException e){
        return new Result<CommonCode>("404",e.getRequestURL());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof Result){
            return body;
        }else if (body instanceof String) {
            // 为什么要特殊处理String https://jpanj.com/2018/SpringBoot-%E4%B8%AD%E7%BB%9F%E4%B8%80%E5%8C%85%E8%A3%85%E5%93%8D%E5%BA%94/
            return objectMapper.writeValueAsString(new Result<String>(body.toString()));
        }
        return new Result<Object>(body);
    }
}
