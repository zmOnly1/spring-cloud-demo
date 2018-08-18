package com.example.consulclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zm on 2018/8/9.
 */
@FeignClient("tomcat")
public interface FeignService {

    @GetMapping("/test1")
    String test1();

    @GetMapping("/test2")
    int test2();

    @GetMapping("/param")
    String test3(@RequestParam("param") String param);
}
