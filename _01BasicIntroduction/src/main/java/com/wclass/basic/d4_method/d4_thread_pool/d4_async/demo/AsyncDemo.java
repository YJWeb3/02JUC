package com.wclass.basic.d4_method.d4_thread_pool.d4_async.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @projectName: 02JUC
 * @ClassName Async
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:54
 * @Version 1.0
 **/
@Component
public class AsyncDemo {

    @Async("getTaskExecutor")
    public void doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }

    @Async("getTaskExector")
    public Future<String> doTaskThree(int i) {
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


}