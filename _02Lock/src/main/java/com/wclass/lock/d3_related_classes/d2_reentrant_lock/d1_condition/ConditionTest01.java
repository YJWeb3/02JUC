package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d1_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ConditionTest01
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:38
 * @Version 1.0
 **/
public class ConditionTest01 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(">>>>>>>>>> " + Thread.currentThread().getName() + "开始处理任务");
                condition.await();
                System.out.println(">>>>>>>>>> " + Thread.currentThread().getName() + "结束处理任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(">>>>>>>>>> " + Thread.currentThread().getName() + "开始处理任务");
                condition.signal();
                System.out.println(">>>>>>>>>> " + Thread.currentThread().getName() + "结束处理任务");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
