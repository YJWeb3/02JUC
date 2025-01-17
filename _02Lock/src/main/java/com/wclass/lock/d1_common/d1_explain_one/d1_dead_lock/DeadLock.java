package com.wclass.lock.d1_common.d1_explain_one.d1_dead_lock;

/**
 * @projectName: 02JUC
 * @ClassName DeadLock
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.14:31
 * @Version 1.0
 **/
public class DeadLock implements Runnable {
    public boolean flag = true;

    // 静态成员属于class，是所有实例对象可共享的
    private static Object o1 = new Object(), o2 = new Object();

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println("线程：" + Thread.currentThread().getName() + "持有o1....");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "等待o2....");
                synchronized (o2) {
                    System.out.println("true");
                }
            }
        }
        if (!flag) {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "持有o2....");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "等待o1....");
                synchronized (o1) {
                    System.out.println("false");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true), "T1");
        Thread t2 = new Thread(new DeadLock(false), "T2");
        // 因为线程调度是按时间片切换决定的，
        // 所以先执行哪个线程是不确定的，也就代表着：
        // 后面的t1.run()可能在t2.run()之前运行
        t1.start();
        t2.start();
    }
}