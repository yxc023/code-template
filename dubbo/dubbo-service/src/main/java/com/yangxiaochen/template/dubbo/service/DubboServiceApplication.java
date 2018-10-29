package com.yangxiaochen.template.dubbo.service;


import org.apache.curator.test.TestingCluster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author yangxiaochen
 * @Date 2018-10-14
 */
@SpringBootApplication
public class DubboServiceApplication {
    public static void main(String[] args) throws Exception {

        TestingCluster cluster = new TestingCluster(1);
        cluster.start();
        Thread.sleep(2000);
        String connectString = cluster.getConnectString();
        String arg1 = "--dubbo.registries[registry2].address=" + connectString;
        String arg2 = "--dubbo.registry.address=" + connectString;
//        args = Arrays.asList(arg1, arg2).toArray(new String[2]);

        System.out.println("service register at " + Arrays.toString(args));
        SpringApplication.run(DubboServiceApplication.class, args);

//        System.out.println("service started. Press any key to exit.");
//        System.in.read();

    }
}
