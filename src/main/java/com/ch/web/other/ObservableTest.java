package com.ch.web.other;


import rx.Observable;
import rx.Subscriber;

/**
 * @author cj-ch
 * @date 2018/4/2 下午7:00
 */
public class ObservableTest {

    public static void main(String[] args) {
        //创建事件源observable
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxJava");
                subscriber.onNext("i am 程序猿");
                subscriber.onCompleted();
            }
        });

        //创建订阅者subscriber
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Subscriber:事件处理完成.");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber:" + s);
            }
        };

        //订阅
        observable.subscribe(subscriber);
    }
}
