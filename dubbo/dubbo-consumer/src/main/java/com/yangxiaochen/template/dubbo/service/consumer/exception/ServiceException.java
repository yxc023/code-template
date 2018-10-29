package com.yangxiaochen.template.dubbo.service.consumer.exception;

/**
 * <p>业务规则造成的业务异常, 并不是错误, 仅需要对用户提示出异常原因.
 *
 * <p>用法举例:
 *
 * <blockquote><pre>
 * throw new ServiceException(MsgBuilder.build("not found uid: {}", 1024)).tip("找不到用户");
 * </pre></blockquote>
 *
 * <p>web 请求中抛到最上层如何处理:
 *
 * <p>com.lianjia.commerce.platform.controller.exception.ExceptionHandler#resolveException()
 *
 * @author yangxiaochen
 * @Date 2018-08-24
 */
public class ServiceException extends RuntimeException {

    private String tip;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException tip(String tip) {
        this.tip = tip;
        return this;
    }

    public String getTip() {
        if (tip == null) {
            return getMessage();
        }
        return tip;
    }

    @Override
    public String getLocalizedMessage() {
        if (tip == null) {
            return super.getLocalizedMessage();
        } else {
            return super.getLocalizedMessage() + " | tip: " + tip;
        }
    }


    public static void main(String[] args) {
        throw new ServiceException(MsgBuilder.build("not found uid: {}", 1024)).tip("找不到用户");
    }
}
