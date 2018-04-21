package com.ch.web.consume;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author cj-ch
 * @date 2018/4/19 下午3:52
 */
//@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver :"+hello);
    }
}
