package com.wclass.lock.d1_common.d2_explain_two.d1_java.d4_synchronized;

/**
 * @projectName: 02JUC
 * @ClassName SynchronizedDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.14:39
 * @Version 1.0
 **/
public class SynchronizedDemo02 {

    Object ob = new Object();

    public void method1() {

        synchronized (ob) {
            // 同步块 A
            method2();
        }
        
    }

    public void method2() {

        synchronized (ob) {
            // 同步块 B
        }

    }

}