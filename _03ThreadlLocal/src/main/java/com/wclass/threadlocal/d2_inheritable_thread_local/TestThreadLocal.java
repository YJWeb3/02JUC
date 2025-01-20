package com.wclass.threadlocal.d2_inheritable_thread_local;

/**
 * @program: 02JUC
 * @ClassName TestThreadLocal
 * @description:
 * @author: CodingW
 * @create: 2025-01-17-22-05
 * @Version 1.0
 **/
public class TestThreadLocal implements Runnable {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println("----主线程设置值为主线程");
        threadLocal.set("主线程");
        System.out.println("----主线程设置后获取值：" + threadLocal.get());
        Thread tt = new Thread(new TestThreadLocal());
        tt.start();
        System.out.println("----主线程结束");

    }

    @Override
    public void run() {
        System.out.println("----子线程设置值前获取：" + threadLocal.get());
        System.out.println("----新开线程设置值为子线程");
        threadLocal.set("子线程");
        System.out.println("----新开的线程设置值后获取：" + threadLocal.get());
    }
}