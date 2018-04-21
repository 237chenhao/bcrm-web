package com.ch.web.produce;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author cj-ch
 * @date 2018/4/19 下午3:49
 */
//@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello" + LocalDateTime.now();
        System.out.println("Sender :" + context);
        this.amqpTemplate.convertAndSend("hello",context);
    }
}
