package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zm on 2018/5/3.
 */
@RestController
public class ApiUserController {

    @RequestMapping(value = "/api/user/get/{id}")
    public User get(@PathVariable int id, @RequestBody(required = false) String json,
                    @RequestParam(required = false) String name, HttpServletRequest request){
        System.out.println("请求方法类型：:" + request.getMethod() + ", body参数：" + json + ", name:" + name);
        return new User(id, "Tom-1", 28);
    }

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable int id) {
        System.out.println("provider:" + id);
        return new User(id, "ds-1", 23);
    }

    @GetMapping("/api/user/2/{id}")
    public User getUser2(@PathVariable int id, @RequestParam(value = "name") String name) {
        System.out.println("provider:" + id + ", name:" + name);
        return new User(id, "peter-1", 25);
    }

    @GetMapping("/hystrix/api/user/{id}")
    public User getHystrix(@PathVariable int id) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("provider:" + id);
        return new User(id, "peter-1", 25);
    }

}
