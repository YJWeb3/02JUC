package com.wclass.basic.d4_method.d4_thread_pool.d1_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @projectName: 02JUC
 * @ClassName ScheduledThreadPoolTest
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:09
 * @Version 1.0
 **/
public class ScheduledThreadPoolTest {

    private static int counter = 0;
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        //提交1000个任务
        for(int i = 0; i < 1000; i++) {
            //submit()会异常处理 底层-> excute(new Runnable(){})
            threadPool.submit(new Add());
        }
        threadPool.shutdown();
        //打印最多使用线程数
        System.out.println("核心线程数: " +threadPool.getCorePoolSize());
        System.out.println("Largest线程数: " +threadPool.getLargestPoolSize());
        System.out.println("同时执行的Maximum线程数: " +threadPool.getMaximumPoolSize());
        System.out.println(counter);
    }

    static class Add implements Runnable {
        @Override
        public void run() {
            counter++;
        }
    }

}
