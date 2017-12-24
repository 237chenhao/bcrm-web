package com.ch.bcrm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin on 2017/12/24.
 */
@RestController
public class HelloWordController {
    @Value("${hello.int}")
    private Integer helloInt;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("")
    public String hello(){
        System.out.println("helloInt:\n"+helloInt);
//        调用服务
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://CH-BCRM-SERVICE/hello", String.class);
        return responseEntity.getBody();
    }
}
