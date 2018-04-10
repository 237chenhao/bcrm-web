package com.ch.web.other;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author cj-ch
 * @date 2018/4/3 上午9:05
 */
public class OtherTest {

    public static void main(String[] args) {
        Thread a = new Thread(new ThreadTest("A"));
        Thread b = new Thread(new ThreadTest("B"));
        a.start();
        b.start();
        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exit");
    }

    static class ThreadTest implements Runnable{

        private String name;
        public ThreadTest(String name){
            this.name = name;
        }
        @Override
        public void run() {
            try {
                int i = new Random().nextInt(3);
                System.out.println(name+i);
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" name="+name);
        }
    }

}
