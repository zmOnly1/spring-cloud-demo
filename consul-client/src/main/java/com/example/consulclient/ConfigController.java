package com.example.consulclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zm on 2018/8/19.
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${author:no one}")
    private String author;

    @GetMapping("/author")
    public String author() {
        return author;
    }
}
