package com.wclass.lock.d3_related_classes.d2_reentrant_lock.d2_use;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: 02JUC
 * @ClassName ReentrantLockDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:39
 * @Version 1.0
 **/
@Slf4j
public class ReentrantLockDemo02 {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        method1();
    }

    public static void method1() {
        lock.lock();
        try {

            log.debug("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        lock.lock();
        try {
            log.debug("execute method2");
            method3();
        } finally {
            lock.unlock();
        }
    }

    public static void method3() {
        lock.lock();
        try {
            log.debug("execute method3");
        } finally {
            lock.unlock();
        }
    }

}
