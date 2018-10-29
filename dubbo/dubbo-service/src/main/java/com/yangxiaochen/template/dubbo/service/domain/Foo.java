package com.yangxiaochen.template.dubbo.service.domain;

import com.yangxiaochen.template.dubbo.service.api.dto.FooDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yangxiaochen
 * @Date 2018-10-24
 */
@Data
public class Foo {

    private Integer id;
    private FooStatusEnum status;

    private Foo.Goo goo;

    @Data
    public static class Goo {
        private String name;
    }


    public enum FooStatusEnum {
        /**
         *
         */
        NORMAL("NORMAL", "正常");

        public final String code;
        public final String name;

        FooStatusEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }


    }
}
