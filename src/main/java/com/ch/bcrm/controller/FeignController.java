package com.ch.bcrm.controller;

import com.ch.bcrm.feign.FeignService;
import com.ch.bcrm.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cj-ch
 * @date 2018/4/9 上午9:13
 */
@RestController
@RequestMapping("")
public class FeignController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private FeignService feignService;

    @RequestMapping("/feign1")
    public String feign1(){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign1();
    }

    @RequestMapping("/feign2")
    public String feign2(@RequestHeader("name") String name){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign2(name);
    }

    @RequestMapping("/feign3")
    public String feign3(){
        log.info("这里是消费者,正在测试feign的功能");
        return feignService.feign3(new User("哈哈哈",18));
    }
}
