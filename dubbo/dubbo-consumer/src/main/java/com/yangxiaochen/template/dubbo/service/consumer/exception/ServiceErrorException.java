package com.yangxiaochen.template.dubbo.service.consumer.exception;

/**
 * <p>业务错误, 业务产生了超出我们业务设计的情况.
 *
 * <p>需要给用户提示出操作为什么不能执行, 还要记录 error 日志, 报警告知开发人员解决
 *
 * <p>用法举例:
 *
 * <blockquote><pre>
 * throw new ServiceErrorException(MsgBuilder.build("not found uid: {}", 1024)).tip("找不到用户");
 * </pre></blockquote>
 *
 * <p>web 请求中抛到最上层如何处理:
 *
 * <p>com.lianjia.commerce.platform.controller.exception.ExceptionHandler#resolveException()
 *
 * @author yangxiaochen
 * @Date 2018-08-24
 */
public class ServiceErrorException extends RuntimeException {

    private String tip = "系统异常";

    public ServiceErrorException() {
    }

    public ServiceErrorException(String message) {
        super(message);
    }

    public ServiceErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceErrorException(Throwable cause) {
        super(cause);
    }

    public ServiceErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceErrorException tip(String tip) {
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
}
