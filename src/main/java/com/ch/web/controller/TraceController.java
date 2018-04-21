package com.ch.web.controller;

import com.ch.web.service.TraceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cj-ch
 * @date 2018/4/20 下午2:49
 */
@RequestMapping("/trace-test")
@RestController
public class TraceController {
    final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ServiceInstance serviceInstance;
    @Autowired
    private TraceService traceService;

    @RequestMapping("")
    public String trace(@RequestParam String params){
        logger.info("===== trace1:{}> =====",params);
        return traceService.trace(params);
    }
}
