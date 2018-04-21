package com.ch.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author cj-ch
 * @date 2018/4/20 下午2:51
 */
@Service
public class TraceService {
    @Autowired
    private RestTemplate restTemplate;

    public String trace(String params){

        String forObject = restTemplate.getForObject("http://micro-service/trace-test?params={params}", String.class, params);
        return forObject;
    }
}
