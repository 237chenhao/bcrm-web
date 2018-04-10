package com.ch.web.controller;

import com.ch.service.api.model.User;
import com.ch.web.feign.FeignService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cj-ch
 * @date 2018/4/9 上午9:13
 */
@RestController
public class FeignController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private FeignService feignService;



    @GetMapping("/feign1")
    public String feign1(){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign1();
    }

    @GetMapping("/feign2")
    public String feign2(@RequestHeader("name") String name){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign2(name);
    }

    @GetMapping("/feign3")
    public String feign3(){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign3(new User("哈哈哈",18));
    }

    @GetMapping("/feign4")
    public String feign4(){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign4();
    }

    @GetMapping("/feign5")
    public String feign5(@RequestHeader("name") String name){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign5(name);
    }

    @PostMapping("/feign6")
    public String feign6(){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign6(new User("哈哈哈",18));
    }
}
