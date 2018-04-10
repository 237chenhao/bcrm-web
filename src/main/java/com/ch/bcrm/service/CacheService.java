package com.ch.bcrm.service;

import com.ch.bcrm.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin on 2018/4/7.
 */
@Service
public class CacheService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserFallback",commandKey = "getUser",groupKey = "user")
    @CacheResult(cacheKeyMethod = "getUserCacheKey")
    public String getUser(Long id){
        ResponseEntity<String> entity = restTemplate.getForEntity("http://micro-service/get-user?id={id}", String.class, id);
        logger.info("请求结果：{}",entity);
        return  entity.getBody();
    }

    String getUserCacheKey(Long id){
        String key = "cahcae-key"+id;
        logger.warn("根据参数(id={})生成缓存Key={}",id,key);
        return key;
    }

    String getUserFallback(Long id,Throwable t){
        logger.warn("getUser={},出现异常了：{}",id,t);
        logger.warn("-------------------------------------------------------------------------------");
        return "getUser异常";
    }
}
