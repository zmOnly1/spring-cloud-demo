package com.example.consulserver;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
 
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulApp3 {
	
    public static void main( String[] args ) {
    	SpringApplication.run(ConsulApp3.class, args);
    }
}
