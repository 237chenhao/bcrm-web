package com.ch.web.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cj-ch
 * @date 2018/4/18 上午9:08
 */
@RefreshScope
@RestController
public class ConfigServerController {

    /**
     * 该配置从spring cloud config中获取可以动态更改
     */
    @Value("${from}")
    private String from;
    @Autowired
    private Environment evn;

    @RequestMapping("/from")
    public String from(){
        return this.from;
    }
}
