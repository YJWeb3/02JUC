package com.wclass.basic.d4_method.d4_thread_pool.d3_executor_contrast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @projectName: 02JUC
 * @ClassName Exectutors
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:45
 * @Version 1.0
 **/
public class ExectutorsDemo01 {

    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交任务到线程池
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " is running by " + Thread.currentThread().getName());
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
