package com.ch.bcrm.controller;


import com.ch.bcrm.service.HelloWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created by admin on 2017/12/24.
 */
@RestController
public class HelloWordController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${hello.int}")
    private Integer helloInt;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ServiceInstance serviceInstance;
    @Autowired
    private HelloWordService helloWordService;
    @RequestMapping("")
    public String hello(){
        logger.info("helloInt:\t{}",helloInt);
        logger.info("serviceInstance:id:{},metadata:{}",serviceInstance.getServiceId(),serviceInstance.getMetadata());
//        调用服务
        return helloWordService.hello();
    }


    @RequestMapping("/async")
    public String asyncHello(){
        logger.info("异步hello:\t{}",helloInt);
//        调用服务
        Future<String> stringFuture = helloWordService.asyncHello();
        long s1 = System.currentTimeMillis();
        logger.info("异步调用完了"+ s1);
        try {
            String s = stringFuture.get();
            logger.info(s);
            s1 = System.currentTimeMillis();
            logger.info("获取异步调用结果完了"+ s1);
            return s;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
