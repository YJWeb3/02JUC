package com.wclass.lock.d2_optimize.d1_no_lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @projectName: 02JUC
 * @ClassName MyObjectDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.13:58
 * @Version 1.0
 **/
public class MyObjectDemo02 {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("10进制hash码："+o.hashCode());
        System.out.println("16进制hash码："+Integer.toHexString(o.hashCode()));
        System.out.println("2进制hash码："+Integer.toBinaryString(o.hashCode()));

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

}
