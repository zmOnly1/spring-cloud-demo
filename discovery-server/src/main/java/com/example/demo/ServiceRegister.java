package com.example.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by zm on 2018/8/6.
 */
@Component
public class ServiceRegister implements ApplicationRunner {

    @Value("${zookeeper.address}")
    private String zkAddress;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, new RetryOneTime(1000));
        client.start();
        client.blockUntilConnected();

        ServiceInstance<Object> instance = ServiceInstance.builder().name("myserver").address("192.168.1.103").port(8080).build();
        ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/soa").build();

        serviceDiscovery.registerService(instance);
        serviceDiscovery.start();
        System.out.println("service reigster finish");
    }
}
