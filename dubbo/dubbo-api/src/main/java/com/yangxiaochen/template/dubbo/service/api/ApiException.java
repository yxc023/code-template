package com.yangxiaochen.template.dubbo.service.api;

/**
 * rpc 接口返回的业务异常, 不同的接口返回的异常该如何处理, 接口提供方应尽量提供一些指导和建议.
 * @author yangxiaochen
 * @Date 2018-10-14
 */
public class ApiException extends RuntimeException {


    /**
     * 不同方法定义不同的 code
     * code 应该在方法注释上说明
     */
    private String code;

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ApiException withCode(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return code;
    }
}
