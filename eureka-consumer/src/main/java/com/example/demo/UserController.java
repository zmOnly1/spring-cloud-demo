package com.example.demo;

import com.example.demo.feign.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zm on 2018/5/3.
 */
@RestController
public class UserController {

    //private static final String URL = "http://localhost:7777/api/user/{id}";
    private static final String URL = "http://eureka-provider/api/user/{id}";
    private static final String URL_HYSTRIX = "http://eureka-provider/hystrix/api/user/{id}";

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id){
        return restTemplate.getForObject(URL, String.class, id);
    }

    @GetMapping("/feign/user/{id}")
    public String getFeignUser(@PathVariable int id){
        return userService.feignUser(id);
    }

    @GetMapping("/feign/user/2/{id}")
    public String getFeignUserChangToPost(@PathVariable int id, String name){
        return userService.changToPost(id, name);
    }

    //hystrix默认线程池方式，可以改为信号量方式适合并发了不高的内部系统
    //@HystrixCommand(fallbackMethod = "getFallback", commandProperties = @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "SEMAPHORE"))
    @HystrixCommand(fallbackMethod = "getFallback")
    @GetMapping("/hystrix/user/{id}")
    public String getUser2(@PathVariable int id){
        return restTemplate.getForObject(URL_HYSTRIX, String.class, id);
    }

    public String getFallback(int id){
        return "hystrix break" + id;
    }
}
