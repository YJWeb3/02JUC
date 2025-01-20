package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d2_use;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ReentrantLockDemo06
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:57
 * @Version 1.0
 **/
@Slf4j
public class ReentrantLockDemo06 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);// 公平锁
        //ReentrantLock lock = new ReentrantLock();// 非公平锁

        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.debug(Thread.currentThread().getName() + " running……");
                } finally {
                    lock.unlock();
                }
            }, "t" + i).start();
        }

        // 1s 后去争抢锁
        Thread.sleep(1000);

        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    log.debug(Thread.currentThread().getName() + " running……");
                } finally {
                    lock.unlock();
                }
            }, "强行插入" + i).start();
        }
    }

}
