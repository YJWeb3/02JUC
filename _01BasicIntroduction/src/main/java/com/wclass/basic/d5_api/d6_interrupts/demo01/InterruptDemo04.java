package com.wclass.basic.d5_api.d6_interrupts.demo01;

/**
 * @projectName: 02JUC
 * @ClassName InterruptDemo04
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.13:43
 * @Version 1.0
 **/
public class InterruptDemo04 extends Thread {
    public static void main(String args[]) throws Exception {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        Thread thread1 = new Thread() {
            public void run() {
                deathLock(lock1, lock2);
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                // 注意，这里在交换了一下位置
                deathLock(lock2, lock1);
            }
        };
        System.out.println("Starting thread...");
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread...");
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    static void deathLock(Object lock1, Object lock2) {
        try {
            synchronized (lock1) {
                Thread.sleep(10);// 不会在这里死掉
                synchronized (lock2) {// 会锁在这里，虽然阻塞了，但不会抛异常
                    System.out.println(Thread.currentThread());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}