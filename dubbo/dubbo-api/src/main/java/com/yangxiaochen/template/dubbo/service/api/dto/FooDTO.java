package com.yangxiaochen.template.dubbo.service.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangxiaochen
 * @Date 2018-10-14
 */
@Data
public class FooDTO implements Serializable {
    private Integer id;
    private String status;
    private String statusName;

    private GooDTO goo;

    @Data
    public static class GooDTO implements Serializable {
        private String name;
    }
}
