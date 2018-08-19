package com.example.consulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zm on 2018/8/19.
 */
@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("balanceRestTemplate")
    @Autowired
    private RestTemplate balanceRestTemplate;

    @Autowired
    private LoadBalancerClient balancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/test1")
    public Object test1() {
        String restRet = restTemplate.getForObject("http://localhost:9955/test1", String.class);

        ServiceInstance instance = balancerClient.choose("tomcat");
        String url = String.format("http://%s:%s/test1", instance.getHost(), instance.getPort());
        String clientRet = restTemplate.getForObject(url, String.class);


        String balanceRestRet = balanceRestTemplate.getForObject("http://tomcat/test1", String.class);

        return String.format("restRet: " + restRet +
                                 ", clientRet: " + clientRet +
                                 ", balanceRestRet: " + balanceRestRet
        );

    }

    @RequestMapping("/disc/test1")
    public Object discTest1() {
        ServiceInstance instance = discoveryClient.getInstances("tomcat").get(0);
        String url = String.format("http://%s:%s/test1", instance.getHost(), instance.getPort());
        return restTemplate.getForObject(url, String.class);
    }

}
