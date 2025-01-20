package com.wclass.basic.d5_api.d2_join.demo03;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:MyThreadLamdaDemo
 * Package:PACKAGE_NAME
 * Description:描述
 *
 * @Date:2022/7/15 14:18
 * @Author:CodingW
 * @Version:1.0
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " 来客人了,准备洗杯子烧水泡茶...");

        Thread th1 = new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 水烧开了...");
        },"烧水" );

        Thread th2 = new Thread( () -> {
            System.out.println(Thread.currentThread().getName() + " 开始洗杯子...");

            for (int i = 0; i <= 10 ; ++ i) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "第" + i + " 个杯子洗好了...");
            }
            System.out.println(Thread.currentThread().getName() + " 杯子洗好了...");

        }, "洗杯子");

        th1.start();
        th2.start();

        th1.join(); // 等待线程运行结束
        th2.join();

        System.out.println(Thread.currentThread().getName() + " 开始泡茶...");

    }
}
