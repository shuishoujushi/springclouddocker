package com.charlie.cloud.feign;

import com.charlie.cloud.User;
import com.charlie.cloud.feign.customizing.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    /**
     * GET请求包含多个参数时Feign接口正确写法：getUser,getUser2
     * @param id
     * @param username
     * @return
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    User getUser(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/getUser2", method = RequestMethod.GET)
    User getUser2(@RequestParam("id")Map<String, Object> map);

    /**
     * POST请求时Feign接口写法
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    User addUser(@RequestBody User user);
}
