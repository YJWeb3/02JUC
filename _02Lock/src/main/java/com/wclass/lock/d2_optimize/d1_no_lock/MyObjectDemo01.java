package com.wclass.lock.d2_optimize.d1_no_lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @projectName: 02JUC
 * @ClassName MyObject
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.13:57
 * @Version 1.0
 **/
public class MyObjectDemo01 {

    public static void main(String[] args) {
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

}
