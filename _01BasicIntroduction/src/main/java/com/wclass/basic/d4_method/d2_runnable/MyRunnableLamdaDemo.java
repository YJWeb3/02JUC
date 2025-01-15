package com.wclass.basic.d4_method.d2_runnable;

/**
 * @projectName: 02JUC
 * @ClassName MyRunnableLamdaDemo
 * @description: 匿名内部类 + Lambda表达式两种方式是心啊
 * @author: CodingW
 * @create: 2025.01.15.16:05
 * @Version 1.0
 **/
public class MyRunnableLamdaDemo {
    public static void main(String[] args) {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " 子线程1输出：" + i);
                }
            }
        };
        Thread t = new Thread(target);
        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " 子线程2输出：" + i);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " 子线程3输出：" + i);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 主线程输出：" + i);
        }
    }
}