package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d2_use;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ReentrantLockDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:39
 * @Version 1.0
 **/
public class ReentrantLockDemo01 {

    private static int sum = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                //加锁
                lock.lock();
                try {
                    //临界区代码
                    //TODO 业务逻辑：读写操作不能保证线程安全
                    for (int j = 0; j < 10000; j++) {
                        sum++;
                    }
                } finally {
                    //解锁
                    lock.unlock();
                }
            });
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println(sum);
    }

}
