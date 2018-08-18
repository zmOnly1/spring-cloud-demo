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

    @RequestMapping("/home")
    public Object home() {
        System.out.println("1111111111111");
        return "OK11";
    }

    @GetMapping("/test1")
    public String test1() {
        return "test11111";
    }

    @GetMapping("/test2")
    public int test2() {
        return 3;
    }

    @GetMapping("/param")
    public String test3(@RequestParam("param")String param) {
        return "test11111" + param;
    }

}
