package com.yangxiaochen.template.dubbo.service.consumer;

import com.yangxiaochen.template.dubbo.service.consumer.exception.ServiceException;
import com.yangxiaochen.template.dubbo.service.consumer.remote.FooRpcWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yangxiaochen
 * @Date 2018-10-14
 */
@SpringBootApplication
public class DubboConsumerApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(DubboConsumerApplication.class, args);

        FooRpcWrapper fooRpcWrapper = applicationContext.getBean(FooRpcWrapper.class);

        System.out.println(fooRpcWrapper.getFoo(1));

        System.out.println(fooRpcWrapper.createFoo("kkk"));

        try {
            fooRpcWrapper.createFoo("repeat");
        } catch (ServiceException e) {
            System.out.println(e.getTip());
        }
    }
}
