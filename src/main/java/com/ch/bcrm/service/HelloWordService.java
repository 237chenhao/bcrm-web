package com.ch.bcrm.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author cj-ch
 * @date 2018/4/2 下午5:28
 */
@Service
public class HelloWordService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;

    /**
     * HystrixCommand 用在依赖的服务放回单个操作结果的时候
     * HystrixObservableCommand 用在依赖的服务返回多个操作结果的时候
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(){
        //        调用服务
        long start = System.currentTimeMillis();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://micro-service/hello", String.class);
        long end = System.currentTimeMillis();
        logger.info("spend time:"+(end - start));
        return responseEntity.getBody();
    }

    @HystrixCommand
    public Future<String> asyncHello(){
        return new AsyncResult<String>(){

            @Override
            public String invoke() {
                //        调用服务
                long start = System.currentTimeMillis();
                ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://micro-service/hello", String.class);
                long end = System.currentTimeMillis();
                logger.info("spend time:"+(end - start));
                return responseEntity.getBody();
            }
        };
    }

    public String helloFallback(Throwable t){
        logger.info("发生异常{},执行服务降级处理逻辑.",t);
        return "error";
    }
}
