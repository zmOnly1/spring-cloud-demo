package com.example.consulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zm on 2018/8/9.
 */
@RestController
public class ConsulController {

    @Autowired
    private FeignService service;

    @GetMapping("/test1")
    public String test1() {
        return service.test1();
    }

    @GetMapping("/test2")
    public int test2() {
        return service.test2();
    }

    @GetMapping("/param")
    public String test3(@RequestParam("param")String param) {
        return service.test3(param);
    }
}
