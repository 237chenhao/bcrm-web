package com.ch.web.rabbitmq;

import com.ch.web.produce.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cj-ch
 * @date 2018/4/19 下午4:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RabbitmqTest {

    @Autowired
    private Sender sender;

    @Test
    public void test1(){
        sender.send();
    }
}

