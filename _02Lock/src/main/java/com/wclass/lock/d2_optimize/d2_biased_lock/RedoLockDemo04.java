package com.wclass.lock.d2_optimize.d2_biased_lock;

import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

/**
 * @projectName: 02JUC
 * @ClassName RedoLockDemo04
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:05
 * @Version 1.0
 **/
public class RedoLockDemo04 {
    static Thread t1, t2, t3;

    public static void main(String[] args) throws InterruptedException {
        int loopNumber = 39;
        Vector<Dog> list = new Vector<>();
        t1 = new Thread(() -> {
            for (int i = 1; i <= loopNumber; i++) {
                Dog d = new Dog();
                list.add(d);
                synchronized (d) {
                    System.out.println(ClassLayout.parseInstance(d).toPrintable());
                }
            }

            LockSupport.unpark(t2);
        }, "t1");
        t1.start();
        t2 = new Thread(() -> {
            LockSupport.park();

            for (int i = 1; i <= loopNumber; i++) {
                Dog d = list.get(i);
                System.out.println(i + "加锁前  " + ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    System.out.println(i + "加锁中  " + ClassLayout.parseInstance(d).toPrintable());
                }
                System.out.println(i + " 加锁后 " + ClassLayout.parseInstance(d).toPrintable());
            }

            LockSupport.unpark(t3);
        }, "t2");
        t2.start();
        t3 = new Thread(() -> {
            LockSupport.park();

            for (int i = 1; i <= loopNumber; i++) {
                Dog d = list.get(i);
                System.out.println(i + "加锁前  " + ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    System.out.println(i + "加锁中  " + ClassLayout.parseInstance(d).toPrintable());
                }
                System.out.println(i + " 加锁后 " + ClassLayout.parseInstance(d).toPrintable());
            }

        }, "t3");
        t3.start();
        t3.join();
        System.out.println(ClassLayout.parseInstance(new Dog()).toPrintable());

    }
    
}

/**
 * @description: -XX:BiasedLockingStartupDelay=0
 */
class Dog02 {
}