package com.wclass.basic.d4_method.d1_extend_thread;

/**
 * @projectName: 02JUC
 * @ClassName MyThreadLambdaDemo
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:04
 * @Version 1.0
 **/
public class MyThreadLambdaDemo {
    public static void main(String[] args) {

        Thread thread = new Thread( () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " 子线程输出：" + i);
            }
        },"CodingW");

        // new Thread().start()在没有执行到start那一步之前,走的是单线程程序
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 主线程输出：" + i);
        }
        // thread.start();// 在线程未调用start()方法时，前面所走的程序还是属于单线程程序，可在次验证！
    }
}
