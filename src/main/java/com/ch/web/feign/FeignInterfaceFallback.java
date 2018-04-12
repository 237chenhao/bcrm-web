package com.ch.web.feign;

import com.ch.service.api.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author cj-ch
 * @date 2018/4/12 上午9:33
 * feign服务降级
 */
@Component
public class FeignInterfaceFallback implements FeignInterface {

    @Override
    public String feign1() {
        return "feign 1 error";
    }

    @Override
    public String feign2(@RequestHeader("name") String name) {
        return "feign 2 error";
    }

    @Override
    public String feign3(@RequestBody User user) {
        return "feign 3 error";
    }

    @Override
    public String feign4() {
        return "feign 4 error";
    }

    @Override
    public String feign5(@RequestHeader("name")String s) {
        return "feign 5 error";
    }

    @Override
    public String feign6(@RequestBody User user) {
        return "feign 6 error";
    }
}
