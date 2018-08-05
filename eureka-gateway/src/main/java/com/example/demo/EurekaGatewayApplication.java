package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EurekaGatewayApplication {

    //@Bean
    //public CustomPreFilter customPreFilter(){
    //    return new CustomPreFilter();
    //}

    public static void main(String[] args) {
        SpringApplication.run(EurekaGatewayApplication.class, args);
    }
}
