package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d2_use;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ReentrantLockDemo07
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:57
 * @Version 1.0
 **/
@Slf4j
public class ReentrantLockDemo07 {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition cigCon = lock.newCondition();
    private static Condition takeCon = lock.newCondition();

    private static boolean hasCig = false;
    private static boolean hasTakeout = false;

    // 送烟
    public void cigarette() {
        lock.lock();
        try {
            while (!hasCig) {
                try {
                    log.debug("没有烟，歇一会儿");
                    cigCon.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            log.debug("有烟了，干活");
        } finally {
            lock.unlock();
        }
    }

    // 送外卖
    public void takeout() {
        lock.lock();
        try {
            while (!hasTakeout) {
                try {
                    log.debug("没有饭，歇一会儿");
                    takeCon.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            log.debug("有饭了，干活");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo07 test = new ReentrantLockDemo07();
        new Thread(() -> test.cigarette()).start();
        new Thread(() -> test.takeout()).start();

        new Thread(() -> {
            lock.lock();
            try {
                hasTakeout = true;
                // 唤醒外卖的等待线程
                takeCon.signal();
            }finally {
                lock.unlock();
            }
        }).start();
    }

}
