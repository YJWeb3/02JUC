package com.wclass.basic.d5_api.d8_thread_state;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:JoinDemo02
 * Package:PACKAGE_NAME
 * Description:描述
 *
 * @Date:2022/7/15 14:25
 * @Author:CodingW
 * @Version:1.0
 */
public class GetStateDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                System.out.println("running...");
            }
        };

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                while (true){

                }
            }
        };
        t2.start();

        Thread t3 = new Thread("t3"){
            @Override
            public void run() {
                System.out.println("running...");
            }
        };
        t3.start();

        Thread t4 = new Thread("t4"){
            @Override
            public void run() {
                synchronized ( GetStateDemo.class ){
                    try {
                        TimeUnit.SECONDS.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();

        Thread t5 = new Thread("t5"){
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t5.start();

        Thread t6 = new Thread("t6"){
            @Override
            public void run() {
                synchronized ( GetStateDemo.class ){
                    try {
                        TimeUnit.SECONDS.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t6.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("t1 - " + t1.getState() ); // NEW new了对象,没有运行
        // t2是一个死循环,正在运行
        System.out.println("t2 - " + t2.getState());
        // t3 TERMINATED,正在运行结束
        System.out.println("t3 - " + t3.getState());
        // t4 TIMED_WAITING有时限的等待
        System.out.println("t4 - " + t4.getState());
        // t5 WAITING 没有限时的等待
        System.out.println("t5 - " + t5.getState());

        // t6 要等待 t4释放资源锁,所以阻塞状态BLOCKED
        System.out.println("t6 - " + t6.getState());
    }
}
