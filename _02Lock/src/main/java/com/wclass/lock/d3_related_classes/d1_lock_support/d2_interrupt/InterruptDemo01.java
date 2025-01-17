package com.wclass.lock.d3_related_classes.d1_lock_support.d2_interrupt;

import java.util.concurrent.locks.LockSupport;

/**
 * @projectName: 02JUC
 * @ClassName InterruptDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.14:28
 * @Version 1.0
 **/
class MyThread extends Thread {
    private Object object;
    public MyThread(Object object) {
        this.object = object;
    }
    public void run() {
        System.out.println("before interrupt");
        try {
            // 休眠3s  为了让主线程先执行park()
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        // 3、执行完park之后，执行中断线程
        thread.interrupt();
        System.out.println("after interrupt");
    }
}
public class InterruptDemo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(Thread.currentThread());
        // 1、执行线程
        myThread.start();
        System.out.println("before park");
        // 2、执行park,获取许可
        LockSupport.park("ParkAndUnparkDemo");
        // 4、线程被成功唤醒了
        System.out.println("after park");
    }
}