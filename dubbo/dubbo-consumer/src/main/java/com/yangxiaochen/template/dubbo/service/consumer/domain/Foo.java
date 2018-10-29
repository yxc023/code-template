package com.yangxiaochen.template.dubbo.service.consumer.domain;

import lombok.Data;

/**
 * @author yangxiaochen
 * @Date 2018-10-18
 */
@Data
public class Foo {
    private Integer id;

    @Data
    public static class Goo {
        private String name;
    }
}
