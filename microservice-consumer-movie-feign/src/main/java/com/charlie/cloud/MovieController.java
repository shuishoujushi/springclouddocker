//package com.charlie.cloud;
//
//import com.charlie.cloud.feign.UserFeignClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.Resource;
//
///**
// * Created by charlie on 26/05/2018.
// */
//
//@RestController
//public class MovieController {
//    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
//
//    @Resource
//    private UserFeignClient userFeignClient;
//
//    @GetMapping(value = "/{id}")
//    public User findById(@PathVariable Long id) {
//        return this.userFeignClient.findById(id);
//    }
//
//}
