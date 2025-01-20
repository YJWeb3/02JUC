package com.wclass.basic.d4_method.d4_thread_pool.d1_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @projectName: 02JUC
 * @ClassName SingleThreadPoolTest
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:09
 * @Version 1.0
 **/
public class SingleThreadPoolTest {

    private static int counter = 0;
    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //提交1000个任务
        for(int i = 0; i < 1000; i++) {
            //submit()会异常处理 底层-> excute(new Runnable(){})
            threadPool.submit(new Add());
        }
        threadPool.shutdown();
        //打印最多使用线程数
        System.out.println(counter);
    }

    static class Add implements Runnable {
        @Override
        public void run() {
            counter++;
        }
    }

}
