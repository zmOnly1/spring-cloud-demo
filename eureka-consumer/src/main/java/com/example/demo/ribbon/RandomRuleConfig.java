package com.example.demo.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * Created by zm on 2018/5/3.
 */
//@Configuration会影响所有的策略，使用该策略
public class RandomRuleConfig {

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }

}
