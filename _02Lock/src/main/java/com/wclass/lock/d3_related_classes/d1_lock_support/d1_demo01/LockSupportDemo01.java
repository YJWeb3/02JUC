package com.wclass.lock.d3_related_classes.d1_lock_support.d1_demo01;

import java.util.concurrent.locks.LockSupport;

/**
 * @projectName: 02JUC
 * @ClassName LockSupportDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:22
 * @Version 1.0
 **/
public class LockSupportDemo01 {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");
    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        t1.interrupt();
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }

}
