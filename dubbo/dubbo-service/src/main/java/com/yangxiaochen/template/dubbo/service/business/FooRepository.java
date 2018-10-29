package com.yangxiaochen.template.dubbo.service.business;

import com.yangxiaochen.template.dubbo.service.domain.Foo;
import org.springframework.stereotype.Repository;

/**
 * @author yangxiaochen
 * @Date 2018-10-24
 */
@Repository
public class FooRepository {

    public Foo getFoo(Integer id) {

        Foo foo = new Foo();
        foo.setId(id);
        foo.setStatus(Foo.FooStatusEnum.NORMAL);

        Foo.Goo goo = new Foo.Goo();
        goo.setName("Michael");
        foo.setGoo(goo);

        return foo;
    }

}
