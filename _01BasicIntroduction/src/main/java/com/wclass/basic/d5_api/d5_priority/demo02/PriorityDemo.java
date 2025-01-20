package com.wclass.basic.d5_api.d5_priority.demo02;

import java.util.concurrent.FutureTask;

/**
 * @projectName: 02JUC
 * @ClassName PriorityDemo
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.11:14
 * @Version 1.0
 **/
public class PriorityDemo {
    public static void main(String[] args) {
        //优先级: 1 - 10 默认值:5
        MyCallable mc = new MyCallable();

        FutureTask<String> ft = new FutureTask<>(mc);

        Thread t1 = new Thread(ft);
        t1.setName("飞机");
        t1.setPriority(10);
        System.out.println(t1.getPriority());//10
        t1.start();

        MyCallable mc2 = new MyCallable();

        FutureTask<String> ft2 = new FutureTask<>(mc2);

        Thread t2 = new Thread(ft2);
        t2.setName("坦克");
        t2.setPriority(1);
        System.out.println(t2.getPriority());//1
        t2.start();
    }
}
