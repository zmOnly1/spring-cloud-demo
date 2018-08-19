package com.example.consulserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zm on 2018/8/9.
 */
@RestController
public class TestController {

    private String consulServer = "Server1:";

    @RequestMapping("/home")
    public Object home() {
        return consulServer + "OK11";
    }

    @GetMapping("/test1")
    public String test1() {
        return consulServer + "test11111";
    }

    @GetMapping("/test2")
    public int test2() {
        return 3;
    }

    @GetMapping("/param")
    public String test3(@RequestParam("param")String param) {
        return consulServer + "test11111" + param;
    }

}
