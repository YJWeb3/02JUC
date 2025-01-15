package com.wclass.basic.d5_api.parkunpark.test01;

import java.util.concurrent.locks.LockSupport;

/*
* LockSupport是一种线程堵塞工具类，所有的方法都是静态的，可以用park来堵塞线程，也可以用unpart来唤醒线程
* */
public class ParkUnparkDemo01 {
    public static void main(String[] args) {
        System.out.println("main start");
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            LockSupport.park();
            System.out.println("t1 end");
        });
        t1.start();
        LockSupport.unpark(t1);
        System.out.println("main end");
    }
}