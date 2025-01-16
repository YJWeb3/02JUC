package com.wclass.basic.d5_api.d5_priority.demo01;

/**
 * @projectName: 02JUC
 * @ClassName ThreadPriority
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.11:12
 * @Version 1.0
 **/
public class ThreadPriority extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }

}