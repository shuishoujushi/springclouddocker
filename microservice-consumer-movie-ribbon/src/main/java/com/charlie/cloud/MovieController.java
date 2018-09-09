package com.charlie.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Value("${user.serviceUrl}")
    private String userServiceUrl;
    @Resource
    RestTemplate restTemplate;
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServiceUrl + id, User.class);
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance instance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点
        logger.info("ServiceId:{}, Host:{}, Port:{}.", instance.getServiceId(), instance.getHost(), instance.getPort());
    }
}
