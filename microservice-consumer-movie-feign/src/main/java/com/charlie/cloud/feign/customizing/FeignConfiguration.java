package com.charlie.cloud.feign.customizing;

import feign.Contract;
import feign.Logger;
import feign.MethodMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Author: Charie
 * 09/09/2018 11:28
 *
 * 该类为Feign配置类
 * 注意：该类不能在主应用程序上下文的@ComponentScan中
 * 可以自定义Feign契约、编码器、解码器、日志打印、添加拦截器
 **/
@Configuration
public class FeignConfiguration {

    /**
     * 将契约改为feign原生的默认契约，这样可以使用feign自带的注解而不是Spring MVC的
     * @return
     */
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
