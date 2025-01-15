package com.wclass.basic.d5_api.sleep;

/*
 * static void sleep(long mills)
 * 作用：让当前线程进入休眠，进入“阻塞”状态，放弃占有CPU时间片，让给其他线程使用
 * */

public class SleepDemo {
    public static void main(String[] args) {
        // 让主线程休眠 5 秒
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		// 5秒之后执行这里代码
        System.out.println("hello yjxz!");
    }
}