package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d2_use;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ReentrantLockDemo05
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:48
 * @Version 1.0
 **/
@Slf4j
public class ReentrantLockDemo05 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            log.debug("t1启动……");

            // 超时
            try {
                if (!lock.tryLock(1, TimeUnit.SECONDS)) {
                    log.debug("等待 1s 后获取锁失败，返回");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

}
