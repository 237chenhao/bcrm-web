package com.ch.bcrm.feign;

import com.ch.bcrm.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj-ch
 * @date 2018/4/9 上午9:14
 */
@FeignClient(value = "micro-service")
public interface FeignService {

    @RequestMapping("/feign1")
    String feign1();

    @RequestMapping("/feign2")
    String feign2(@RequestHeader("name") String name);

    @RequestMapping("/feign3")
    String feign3(@RequestBody User user);
}
