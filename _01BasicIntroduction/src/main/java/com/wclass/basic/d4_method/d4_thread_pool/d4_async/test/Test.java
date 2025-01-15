package com.wclass.basic.d4_method.d4_thread_pool.d4_async.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * @projectName: 02JUC
 * @ClassName Test
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:57
 * @Version 1.0
 **/
@Component
public class Test {

    @Async
    public void doTaskThree(CountDownLatch countDownLatch, int i) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("第00" + i + "完成任务，耗时：" + (end - start) + "毫秒，线成名为::" + Thread.currentThread().getName());
        countDownLatch.countDown();
    }


    @Async("getTaskExector")
    public Future<String> doTaskThree02(int i) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("第00" + i + "完成任务，耗时：" + (end - start) + "毫秒，线成名为::" + Thread.currentThread().getName());
        return new AsyncResult("SUCUESS");
    }



    // 注意这个多线程方法的类一定要加@Component注解，拿给spring容器管理
    @Async
    public void doTaskThree(int i) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("第00" + i + "完成任务，耗时：" + (end - start) + "毫秒，线成名为::" + Thread.currentThread().getName());

    }


}