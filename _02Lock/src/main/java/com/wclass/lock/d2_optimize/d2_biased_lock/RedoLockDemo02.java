package com.wclass.lock.d2_optimize.d2_biased_lock;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: 02JUC
 * @ClassName RedoLockDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:02
 * @Version 1.0
 **/
public class RedoLockDemo02 {

    public static void main(String[] args) {
        Object object = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (object) {
                try {
                    System.out.println(ClassLayout.parseInstance(object).toPrintable());
                    object.wait();
                    System.out.println("被唤醒");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(ClassLayout.parseInstance(object).toPrintable());

        }, "t1");
        t1.start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                object.notifyAll();
                System.out.println("notifyAll");
            }
        }, "t2").start();
    }

}
