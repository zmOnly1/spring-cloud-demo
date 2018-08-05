package com.example.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zm on 2018/5/5.
 */
@FeignClient(value = "eureka-provider", configuration = FeignConfiguration.class, fallback = RcUserServiceFallBack.class)
public interface UserService {

    //@RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/api/user/{id}")
    String feignUser(@PathVariable(value = "id") int id);

    /**
     *
     * 在feign中检验比较严格@PathVariable(value = "id")必须写全，而且只能有一个无注解的参数，比如name，再多写一个将报错
     * 如果name不加@RequestParam，那么将会将name转为postbody，http请求方法会转成post，即使是get请求
     */
    //@RequestMapping(value = "/api/user/2/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/api/user/get/{id}")
    String changToPost(@PathVariable(value = "id") int id,String name);

    ////对应feign的contract
    //@RequestLine("GET /api/user/{id}")
    //String view3(@Param(value = "id")int id);
}
