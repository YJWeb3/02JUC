package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d2_use;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ReentrantLockDemo04
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:47
 * @Version 1.0
 **/
@Slf4j
public class ReentrantLockDemo04 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            log.debug("t1启动……");

            // 注意：即使是设置公平锁，此方法也会立即返回获取锁成功或失败，公平策略不生效
            if (!lock.tryLock()) {
                log.debug("t1获取锁失败，立即返回false");
                return;
            }

            try {
                log.debug("t1获得锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        try {
            log.debug("main线程获得了锁");
            t1.start();
            //先让线程 t1 执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

}
