package com.wclass.basic.d5_api.d6_interrupts.demo01;

/**
 * @projectName: 02JUC
 * @ClassName InterruptDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.13:42
 * @Version 1.0
 **/
public class InterruptDemo02 extends Thread {
    public static void main(String args[]) throws Exception {
        InterruptDemo02 thread = new InterruptDemo02();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        // 发出中断请求
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    public void run() {
        // 每隔一秒检测是否设置了中断标示
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread is running...");
            long time = System.currentTimeMillis();
            // 使用while循环模拟 sleep
            while ((System.currentTimeMillis() - time < 1000) ) {
            }
        }
        System.out.println("Thread exiting under request...");
    }
}
