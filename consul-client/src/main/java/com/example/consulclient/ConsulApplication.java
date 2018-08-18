package com.example.consulclient;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class ConsulApplication {
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * 从所有服务中选择一个服务（轮询）
	 */
	@RequestMapping("/discover")
	public Object discover() {
		return loadBalancer.choose("tomcat").getUri().toString();
	}
	
	/**
	 * 获取所有服务 
	 */
	@RequestMapping("/services")
	public Object services() {
		return discoveryClient.getInstances("tomcat");
	}
	
    public static void main( String[] args ) {
    	SpringApplication.run(ConsulApplication.class, args);
    }
}
