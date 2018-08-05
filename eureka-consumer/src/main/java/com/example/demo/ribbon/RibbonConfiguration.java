package com.example.demo.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zm on 2018/5/3.
 */
@Configuration
@RibbonClient(name = "eureka-provider", configuration = RandomRuleConfig.class)
public class RibbonConfiguration {

}
