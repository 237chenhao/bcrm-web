package com.ch.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin on 2017/12/24.
 */
//@SpringBootApplication
//@EnableDiscoveryClient
////开启断路器功能
//@EnableCircuitBreaker

/**
 *  包含这三个
 *  @SpringBootApplication
     @EnableDiscoveryClient
     @EnableCircuitBreaker
 */
@SpringCloudApplication
//开启Feign的支持功能
@EnableFeignClients
public class ChBcrmWebApplication {
    /**
     * 软负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ChBcrmWebApplication.class,args);
    }
}
