package com.ch.web.feign;


import com.ch.service.api.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj-ch
 * @date 2018/4/9 上午9:14
 */
@FeignClient(value = "micro-service",fallback = FeignInterfaceFallback.class,configuration = FeignInterfaceConfiguration.class)
public interface FeignInterface extends com.ch.service.api.feign.FeignService {

    @RequestMapping("/feign1")
    String feign1();

    @RequestMapping("/feign2")
    String feign2(@RequestHeader("name") String name);

    @RequestMapping("/feign3")
    String feign3(@RequestBody User user);
}
