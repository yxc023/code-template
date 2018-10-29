package com.yangxiaochen.template.dubbo.service.consumer.exception;

import org.slf4j.helpers.MessageFormatter;

/**
 * @author yangxiaochen
 * @Date 2018-08-24
 */
public class MsgBuilder {
    public static String build(String message, Object...args) {
        return MessageFormatter.arrayFormat(message, args).getMessage();
    }
}
