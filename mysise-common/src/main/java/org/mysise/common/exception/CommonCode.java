package org.mysise.common.exception;


import org.mysise.common.constant.Constant;

/**
 * <p>
 *  公用错误枚举类
 * <p>
 *
 * @author fanwenjie@mysise.org
 * @since 2020/5/11 22:01
 */
public enum CommonCode implements BaseException {

    /**
     * <p>
     *
     * <p>
     *
     * @since 2020/5/4 17:43
     */
    SUCCESS(Constant.SUCCESS,"ok"),
    SERVER_ERROR(Constant.SERVER_ERROR,"server fail");



    private String code;
    private String message;

    CommonCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
