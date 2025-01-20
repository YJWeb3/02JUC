package com.wclass.lock.d2_optimize.d2_biased_lock;

import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;

/**
 * @projectName: 02JUC
 * @ClassName RedoLockDemo3
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:03
 * @Version 1.0
 **/
public class RedoLockDemo03 {

    public static void main(String[] args) {
        Vector<Dog> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                Dog d = new Dog();
                list.add(d);
                synchronized (d) {
                    System.out.println(ClassLayout.parseInstance(d).toPrintable());
                }
            }
            synchronized (list) {
                list.notify();//唤醒t2
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (list) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 30; i++) {
                Dog d = list.get(i);
                System.out.println(i + "加锁前  " + ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    System.out.println(i + "加锁中  " + ClassLayout.parseInstance(d).toPrintable());
                }
                System.out.println(i + " 加锁后 " + ClassLayout.parseInstance(d).toPrintable());
            }
        }, "t2");
        t2.start();
    }

}

/**
 * @description: -XX:BiasedLockingStartupDelay=0
 *这里我将jol的源码新增了只输出简化的二进制信息toPrintable2()并且修正了二进制顺序，然后再打成jar包在本地引入
 */
class Dog {
}