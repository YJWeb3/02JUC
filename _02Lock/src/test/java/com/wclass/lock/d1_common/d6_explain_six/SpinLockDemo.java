package com.wclass.lock.d1_common.d6_explain_six;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @projectName: 02JUC
 * @ClassName SpinLockDemo
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.14:48
 * @Version 1.0
 **/
public class SpinLockDemo {
    /**
     * 锁的持有者
     */
    private AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * 记录锁重入次数
     */
    private volatile int count = 0;

    public void lock() {
        Thread current = Thread.currentThread();
        // 当前线程已经持有锁, 则记录重入次数即可
        if( current == owner.get() ) {
            count++;
            return;
        }

        while ( !owner.compareAndSet(null, current) );
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if( current == owner.get() ) {
            if( count>0 ) {
                // 锁重入, 直接自减即可
                count--;
            } else {
                owner.set(null);
            }
        }
    }

    public static void main(String[] args) {
        SpinLockDemo spinLock = new SpinLockDemo();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
                spinLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    spinLock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放了了自旋锁");
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}
