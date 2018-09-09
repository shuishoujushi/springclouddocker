package com.charlie.cloud;

import com.charlie.cloud.feign.customizing.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Charie
 * 09/09/2018 12:47
 **/
@Import(FeignClientsConfiguration.class)
@RestController
public class CustomizeFeignController {
    private UserFeignClient userUserFeignClient;
    private UserFeignClient adminUserFeignClient;

    @RequestMapping(value = "/user-user/security/{id}", method = RequestMethod.GET)
    public User findByUser(@PathVariable Long id) {
        return this.userUserFeignClient.findById(id);
    }

    @RequestMapping(value = "/user-admin/security/{id}", method = RequestMethod.GET)
    public User findByAdmin(@PathVariable Long id) {
        return this.adminUserFeignClient.findById(id);
    }

    @Autowired
    public CustomizeFeignController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "password1"))
                .target(UserFeignClient.class, "http://microservice-provider-user/");
        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2"))
                .target(UserFeignClient.class, "http://microservice-provider-user/");
    }
}
