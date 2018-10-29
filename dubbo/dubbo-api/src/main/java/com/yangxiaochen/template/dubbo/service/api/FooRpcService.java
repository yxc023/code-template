package com.yangxiaochen.template.dubbo.service.api;

import com.yangxiaochen.template.dubbo.service.api.dto.FooDTO;

/**
 * 努力做到代码即文档
 * @author yangxiaochen
 * @Date 2018-10-14
 */
public interface FooRpcService {


    /**
     * only for {@link #createFoo(FooDTO foo)}
     */
    String CODE_ARGS_ERROR = "ARGS_ERROR";
    /**
     * only for {@link #createFoo(FooDTO foo)}
     */
    String CODE_REPEAT_NAME = "REPEAT_NAME";

    /**
     * 根据 id 获取
     * @param id
     * @return null if not find
     */
    FooDTO getFoo(Integer id);

    /**
     * 创建 foo 对象, 并返回带有 id 的 foo 对象
     * @param foo data to create
     * @return created foo
     * @throws ApiException if can not create<br>
     * Exception code:<br>
     * {@link #CODE_ARGS_ERROR} - 参数错误<br>
     * {@link #CODE_REPEAT_NAME} - 名字重复<br>
     *
     */
    FooDTO createFoo(FooDTO foo) throws ApiException;
}
