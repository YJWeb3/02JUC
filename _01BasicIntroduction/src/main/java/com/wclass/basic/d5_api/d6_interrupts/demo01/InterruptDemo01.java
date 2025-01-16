package com.wclass.basic.d5_api.d6_interrupts.demo01;

/**
 * @projectName: 02JUC
 * @ClassName InterruptDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.13:41
 * @Version 1.0
 **/
public class InterruptDemo01 extends Thread {
    volatile boolean stop = false;// 线程中断信号量

    public static void main(String args[]) throws Exception {
        InterruptDemo01 thread = new InterruptDemo01();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        // 设置中断信号量
        thread.stop = true;
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    public void run() {
        // 每隔一秒检测一下中断信号量
        while (!stop) {
            System.out.println("Thread is running...");
            long time = System.currentTimeMillis();
            /*
             * 使用while循环模拟 耗时 方法，这里不要使用sleep，否则在阻塞时会 抛
             * InterruptedException异常而退出循环，这样while检测stop条件就不会执行，
             * 失去了意义。
             */
            while ((System.currentTimeMillis() - time < 1000)) {}
            //[code1]
        }
        System.out.println("Thread exiting under request...");
    }
}
