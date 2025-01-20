package com.wclass.basic.d5_api.d5_priority.demo02;

import java.util.concurrent.Callable;

/**
 * @projectName: 02JUC
 * @ClassName MyCallable
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.11:14
 * @Version 1.0
 **/
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
        return "线程执行完毕了";
    }
}
