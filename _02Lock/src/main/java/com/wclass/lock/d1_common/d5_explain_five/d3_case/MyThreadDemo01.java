package com.wclass.lock.d1_common.d5_explain_five.d3_case;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName MyThreadDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.14:46
 * @Version 1.0
 **/
public class MyThreadDemo01 implements Runnable {
    private Lock lock;

    public MyThreadDemo01(Lock lock) {
        this.lock = lock;
    }

    public void run() {
        lock.lock();    // 获取锁
        try {
            System.out.println(Thread.currentThread().getName() + " 获取了锁");
            Thread.sleep(1000);    // 模拟业务处理
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();    // 释放锁
            System.out.println(Thread.currentThread().getName() + " 释放了锁");
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        MyThreadDemo01 thread1 = new MyThreadDemo01(lock);
        MyThreadDemo01 thread2 = new MyThreadDemo01(lock);
        Thread t1 = new Thread(thread1, "Thread 1");
        Thread t2 = new Thread(thread2, "Thread 2");
        t1.start();
        t2.start();
    }
}