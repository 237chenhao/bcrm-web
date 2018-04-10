package com.ch.web.other;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cj-ch
 * @date 2018/4/3 上午9:05
 */
public class OtherTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                20,50,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1024));
        int i  =50;
        while(i-- > 0){
            String name = RandomStringUtils.randomAlphabetic(4);
            executor.submit(new ThreadTest(name));
        }

        System.out.println("main thread exit");
    }

    static class ThreadTest implements Runnable{

        private String name;
        RestTemplate restTemplate = new RestTemplate();
        public ThreadTest(String name){
            this.name = name;
        }
        @Override
        public void run() {
            while (true){
                int i = new Random().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String forObject = restTemplate.getForObject("http://localhost:8090", String.class);
                System.out.println(name+"本次延时"+i+"s,返回="+forObject);
            }
        }
    }

}
