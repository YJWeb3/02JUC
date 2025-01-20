package com.wclass.basic.d5_api.d3_sleep;

/**
 * @projectName: 02JUC
 * @ClassName SleepDemo
 * @description: 作用：让当前线程进入休眠，进入“阻塞”状态，放弃占有CPU时间片，让给其他线程使用
 * @author: CodingW
 * @create: 2025.01.16.11:08
 * @Version 1.0
 **/
public class SleepDemo {

    // 作用：让当前线程进入休眠，进入“阻塞”状态，放弃占有CPU时间片，让给其他线程使用
    public static void main(String[] args) {
        // 让主线程休眠 5 秒
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5秒之后执行这里代码
        System.out.println("hello CodingW!");
    }

}
