package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zm on 2018/8/5.
 */
@RestController
public class ConfigController {

    @Value("${profile:}")
    private String profile;

    @GetMapping("/profile")
    public String getProfile(){
        System.out.println("hello" + profile);
        return profile;
    }
}
