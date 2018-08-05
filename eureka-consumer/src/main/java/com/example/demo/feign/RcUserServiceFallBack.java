package com.example.demo.feign;

import org.springframework.stereotype.Component;

/**
 * Created by zm on 2018/5/6.
 */
@Component
public class RcUserServiceFallBack implements UserService{

    @Override
    public String feignUser(int id) {
        return "no user";
    }

    @Override
    public String changToPost(int id, String name) {
        return "system error";
    }
}
