package com.yangxiaochen.template.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yangxiaochen.template.dubbo.service.api.ApiException;
import com.yangxiaochen.template.dubbo.service.api.FooRpcService;
import com.yangxiaochen.template.dubbo.service.api.dto.FooDTO;
import com.yangxiaochen.template.dubbo.service.business.FooRepository;
import com.yangxiaochen.template.dubbo.service.domain.Foo;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yangxiaochen
 * @Date 2018-10-14
 */
@Service(registry = "registry2", accesslog = "kkk")
public class FooRpcServiceImpl implements FooRpcService {

    @Autowired
    FooRepository fooRepository;

    @Override
    public FooDTO getFoo(Integer id) {

        // 从业务层获取信息, 转化为传输对象输出

        Foo foo = fooRepository.getFoo(id);

        FooDTO fooDTO = new FooDTO();
        BeanCopy.from(foo).to(fooDTO).copy();

        // enum 类型不适合在 rpc 中传递, 不方便升级
        fooDTO.setStatus(foo.getStatus().code);
        fooDTO.setStatusName(foo.getStatus().name);

        return fooDTO;
    }

    @Override
    public FooDTO createFoo(FooDTO foo) throws ApiException {
        if (foo.getGoo() == null) {
            throw new ApiException("goo 不能为空").withCode(CODE_ARGS_ERROR);
        }
        if ("repeat".equalsIgnoreCase(foo.getGoo().getName())) {
            throw new ApiException("name 重复").withCode(CODE_REPEAT_NAME);
        }
        foo.setId(100);

        // ... 省略调用业务代码

        return foo;
    }
}
