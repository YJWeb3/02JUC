package com.wclass.lock.d3_related_classes.d1_lock_support.d1_demo01;

import java.util.concurrent.locks.LockSupport;

/**
 * @projectName: 02JUC
 * @ClassName LockSupportDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:24
 * @Version 1.0
 **/
public class LockSupportDemo02 {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }
        @Override public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            }
        }
    }
    public static void main(String[] args) {
        t1.start();
        LockSupport.unpark(t1);
        System.out.println("unpark invoked");
    }

}
