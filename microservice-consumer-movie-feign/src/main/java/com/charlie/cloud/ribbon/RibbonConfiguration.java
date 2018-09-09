/*package com.charlie.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*//**
 * 自定义Ribbon配置类，此类会覆盖默认配置类RibbonClientConfiguration
 * 注意：该类不应该在主应用程序上下文的@ComponentScan中
 *//*

@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}*/
