package com.wclass.basic.d5_api.d10_parkunpark;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * ClassName:MyCallableLambdaDemo
 * Package:PACKAGE_NAME
 * Description:描述
 *
 * @Date:2022/7/15 15:29
 * @Author:CodingW
 * @Version:1.0
 */
public class ParkUnparkDemo02 {
    public static void main(String[] args) throws InterruptedException {
    	test();
    }

    public static void test() throws InterruptedException{
        Thread th = new Thread( () -> {
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(System.currentTimeMillis() + " -park...");
            LockSupport.park(); // 打断线程,线程就会停止在这里
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(System.currentTimeMillis() + " - unpark...");
            // 当打断状态为true时,调用park会失效,我们必须重置下这个标记
            // System.out.println(Thread.interrupted());
            System.out.println(Thread.currentThread().isInterrupted());
            LockSupport.park(); // 再次打断
            System.out.println(System.currentTimeMillis() + " - park...");
        },"t");

        th.start();
        TimeUnit.MILLISECONDS.sleep(100);
        LockSupport.unpark(th);
        // th.interrupt();

        TimeUnit.MILLISECONDS.sleep(200);
        LockSupport.unpark(th);
    }
}
