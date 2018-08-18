package com.example.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;

import java.util.*;

/**
 * Created by zm on 2018/8/6.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", new RetryOneTime(1000));
        client.start();
        client.blockUntilConnected();

        ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/soa").build();

        Collection<ServiceInstance<Object>> list = serviceDiscovery.queryForInstances("myserver");
        list.forEach((instance) -> {
            System.out.println(instance.getAddress());
            System.out.println(instance.getPort());
        });
    }

}
