package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer3Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer3Application.class, args);
    }
}
