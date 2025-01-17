package com.wclass.lock.d1_common.d6_expalin_six.d3_case.d2_fair_self_lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: 02JUC
 * @ClassName SpinLockFairDemo
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.14:48
 * @Version 1.0
 **/
public class SpinLockFairDemo {

    /**
     * 当前持有锁的号码
     */
    private AtomicInteger serviceNum = new AtomicInteger(0);

    /**
     * 记录锁重入次数
     */
    private volatile int count = 0;

    /**
     * 排队号码
     */
    private AtomicInteger ticketNum = new AtomicInteger(0);

    /**
     * 各线程存放自己所申请的排队号码
     */
    private static ThreadLocal<Integer> threadLocalNum = new ThreadLocal<>();

    public void lock() {
        Integer num = threadLocalNum.get();
        if( num!=null && num==serviceNum.get() ) {
            // 当前线程已经持有锁, 则记录重入次数即可
            count++;
            return;
        }

        // 申请一个排队号码
        num = requestTicketNum();
        threadLocalNum.set( num );
        // 自旋等待, 直到该排队号码与serviceNum相等
        while ( num != this.serviceNum.get() );
    }

    public void unlock() {
        Integer num = threadLocalNum.get();
        if( num!=null && num==serviceNum.get() ) {
            if( count>0 ) {
                // 锁重入, 直接自减即可
                count--;
            } else {
                threadLocalNum.remove();
                // 自增serviceNum, 以便下一个排队号码的线程能够退出自旋
                serviceNum.set( num+1 );
            }
        }
    }

    /**
     * 申请一个排队号码
     */
    private int requestTicketNum() {
        return ticketNum.getAndIncrement();
    }

    public static void main(String[] args) {
        SpinLockFairDemo spinLock = new SpinLockFairDemo();
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
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}