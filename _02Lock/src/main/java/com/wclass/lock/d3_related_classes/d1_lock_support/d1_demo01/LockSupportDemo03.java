package com.wclass.lock.d3_related_classes.d1_lock_support.d1_demo01;

import java.util.concurrent.locks.LockSupport;

/**
 * @projectName: 02JUC
 * @ClassName LockSupportDemo03
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:25
 * @Version 1.0
 **/
public class LockSupportDemo03 {

    public static void main(String[] args) {

    }

    public static void test01() {
        final Object obj = new Object();
        Thread A = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            try {
                obj.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        obj.notify();
    }

    public static void test02() {
        final Object obj = new Object();
        Thread A = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        });
        A.start();
        // 睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (obj) {
            obj.notify();
        }
    }

    public static void test03() {
        Thread A = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            LockSupport.park();
            System.out.println(sum);
        });
        A.start();
        // 睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LockSupport.unpark(A);
    }

    public static void test04() {
        final Object obj = new Object();
        Thread A = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        });
        A.start();
        // 睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        //Thread.sleep(1000);
        synchronized (obj) {
            obj.notify();
        }
    }

    public static void test05() {
        Thread A = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            LockSupport.park();
            System.out.println(sum);
        });
        A.start();
        // 睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        //Thread.sleep(1000);
        LockSupport.unpark(A);
    }
}
