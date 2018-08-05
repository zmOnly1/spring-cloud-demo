package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider1Application.class, args);
    }
}
