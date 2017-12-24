package com.ch.bcrm.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/12/24.
 */
@RestController
public class HelloWordController {
    @Value("${hello.int}")
    private Integer helloInt;
    @RequestMapping("")
    public String hello(){
        System.out.println("helloInt:\n"+helloInt);
        return "hello word!";
    }
}
