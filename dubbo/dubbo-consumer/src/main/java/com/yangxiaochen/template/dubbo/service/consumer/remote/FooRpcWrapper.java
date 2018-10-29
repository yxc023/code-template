package com.yangxiaochen.template.dubbo.service.consumer.remote;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yangxiaochen.template.dubbo.service.api.ApiException;
import com.yangxiaochen.template.dubbo.service.api.FooRpcService;
import com.yangxiaochen.template.dubbo.service.api.dto.FooDTO;
import com.yangxiaochen.template.dubbo.service.consumer.domain.Foo;
import com.yangxiaochen.template.dubbo.service.consumer.exception.ServiceException;
import jodd.bean.BeanCopy;
import org.springframework.stereotype.Service;

/**
 * 接口访问封装层:
 * 1. 接口数据与业务数据的转换.
 * 2. 接口异常与业务异常的转换.
 *
 * @author yangxiaochen
 * @Date 2018-10-14
 */
@Service
public class FooRpcWrapper {

    @Reference(registry = "r1")
    FooRpcService fooRpcService;

    public Foo getFoo(Integer id) {
        // 对于读操作, 很少需要处理异常
        FooDTO fooDTO = fooRpcService.getFoo(id);

        // 将接口传值对象, 转化为我们业务中的对象
        Foo foo = new Foo();
        BeanCopy.from(fooDTO).to(foo).copy();
        return foo;
    }

    public Foo createFoo(String name) {
        FooDTO fooDTO = new FooDTO();
        FooDTO.GooDTO gooDTO = new FooDTO.GooDTO();
        gooDTO.setName(name);
        fooDTO.setGoo(gooDTO);

        FooDTO created = null;
        try {
            // 对于写操作, 通常要考虑异常
            created = fooRpcService.createFoo(fooDTO);
        } catch (ApiException e) {
            if (e.getCode().equals(FooRpcService.CODE_ARGS_ERROR)) {
                // 不可能会这样
            } else if (e.getCode().equals(FooRpcService.CODE_REPEAT_NAME)) {
                // 将接口的异常传化为我们项目中自己的异常, 返回给用户
                throw new ServiceException("repeat name: " + name).tip("输入名称已存在");
            }
        }

        // 将接口传值对象, 转化为我们业务中的对象
        Foo foo = new Foo();
        BeanCopy.from(created).to(foo).copy();
        return foo;
    }
}
