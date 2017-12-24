package com.ch.bcrm.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by admin on 2017/12/24.
 */
@SpringBootApplication
@Import(value = {
        WebConfig.class
})
public class BcrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(BcrmApplication.class,args);
    }
}
