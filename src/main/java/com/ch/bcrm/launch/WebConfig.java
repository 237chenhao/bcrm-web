package com.ch.bcrm.launch;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2017/12/24.
 */
@Configuration
@ComponentScan(value = {
        "com.ch.bcrm.web"
})
public class WebConfig {
}
