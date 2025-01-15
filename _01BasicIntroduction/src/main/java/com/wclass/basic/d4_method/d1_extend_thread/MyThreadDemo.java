package com.wclass.basic.d4_method.d1_extend_thread;

/**
 * @projectName: 02JUC
 * @ClassName MyThreadDemo
 * @description: 创建线程方式一：继承Thread
 * @author: CodingW
 * @create: 2025.01.15.16:03
 * @Version 1.0
 **/
public class MyThreadDemo {
    public static void main(String[] args) {
        // 3. new一个新线程对象
        Thread t = new MyThread();
        // 4. 调用start方法启动线程（执行的还是run方法）
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 主线程输出：" + i);
        }

    }
}

/**
 * 1. 定义一个线程类继承Thread类
 */
class MyThread extends Thread {
    /**
     * 2. 重写run方法，里面是定义线程以后要干啥
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 子线程输出：" + i);
        }
    }
}