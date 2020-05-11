package org.mysise.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  数据库异常
 * <p>
 *
 * @author fanwenjie@mysise.org
 * @since 2020/5/11 22:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SqlException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public SqlException() {
        super();
    }

    public SqlException(BaseException baseException) {
        super(baseException.getCode());
        this.errorCode = baseException.getCode();
        this.errorMsg = baseException.getMessage();
    }

    public SqlException(BaseException baseException, String  message) {
        super(baseException.getCode());
        this.errorCode = baseException.getCode();
        this.errorMsg = message;
    }

    public SqlException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public SqlException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public SqlException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }




    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
