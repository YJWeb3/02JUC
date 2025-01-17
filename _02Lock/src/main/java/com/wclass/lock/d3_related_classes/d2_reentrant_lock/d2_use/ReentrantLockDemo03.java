package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d2_use;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ReentrantLockDemo03
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:47
 * @Version 1.0
 **/
@Slf4j
public class ReentrantLockDemo03 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            log.debug("t1启动……");

            try {
                lock.lockInterruptibly();
                try {
                    log.debug("t1获得了锁");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("t1等锁的过程被中断");
            }
        }, "t1");

        lock.lock();
        try {
            log.debug("main线程获得了锁");
            t1.start();
            //先让线程 t1 执行
            Thread.sleep(1000);

            t1.interrupt();
            log.debug("线程 t1 执行中断");
        } finally {
            lock.unlock();
        }
    }

}
