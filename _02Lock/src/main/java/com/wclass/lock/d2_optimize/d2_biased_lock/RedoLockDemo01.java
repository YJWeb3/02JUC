package com.wclass.lock.d2_optimize.d2_biased_lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @projectName: 02JUC
 * @ClassName RedoLockDemo01
 * @description: -XX:BiasedLockingStartupDelay=0
 * @author: CodingW
 * @create: 2025.01.17.14:02
 * @Version 1.0
 **/
public class RedoLockDemo01 {

    public static void main(String[] args) {
        Object object = new Object();

        new Thread(() -> {
            synchronized (object) {
                System.out.println(ClassLayout.parseInstance(object).toPrintable());
            }
            object.hashCode();
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }, "t1").start();
    }

}
