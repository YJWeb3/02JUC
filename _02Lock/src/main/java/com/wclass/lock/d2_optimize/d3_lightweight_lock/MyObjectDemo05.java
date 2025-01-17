package com.wclass.lock.d2_optimize.d3_lightweight_lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @projectName: 02JUC
 * @ClassName MyObjectDemo05
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:07
 * @Version 1.0
 **/
public class MyObjectDemo05 {

    public static void main(String[] args) {
        Object object = new Object();

        new Thread(() -> {
            synchronized (object) {
                System.out.println(ClassLayout.parseInstance(object).toPrintable());
            }
        }, "t1").start();
    }

}
