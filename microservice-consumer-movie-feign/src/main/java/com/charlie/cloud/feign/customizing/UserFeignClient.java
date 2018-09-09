package com.charlie.cloud.feign.customizing;

import com.charlie.cloud.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Author: Charie
 * 09/09/2018 11:34
 **/
// 使用自定义Feign时注释掉FeignClient
//@FeignClient(name = "MICROSERVICE-PROVIDER-USER", configuration = FeignConfiguration.class)
public interface UserFeignClient {
    /**
     * 使用feign自带的注解@RequestLine
     * @see https://github.com/OpenFeign/feign
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
