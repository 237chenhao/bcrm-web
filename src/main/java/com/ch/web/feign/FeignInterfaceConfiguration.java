package com.ch.web.feign;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author cj-ch
 * @date 2018/4/12 上午10:17
 * feign配置
 */
@Configuration
public class FeignInterfaceConfiguration {
    /**
     * 配置feign日志
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 配置关闭hytrix
     * @return
     */
//    @Bean
//    @Scope(value = "prototype")
//    Feign.Builder feignBuilder(){
//        return Feign.builder();
//    }
}
