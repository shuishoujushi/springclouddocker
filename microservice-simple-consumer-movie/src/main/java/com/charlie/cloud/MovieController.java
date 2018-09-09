package com.charlie.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by charlie on 26/05/2018.
 */
@RestController
public class MovieController {

    @Value("${user.serviceUrl}")
    private String userServiceUrl;

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = this.restTemplate.getForObject(this.userServiceUrl + id, User.class);
        return findOne;
    }
}
