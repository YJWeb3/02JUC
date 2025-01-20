package com.wclass.threadlocal.d2_inheritable_thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: 02JUC
 * @ClassName TestInheritableThreadLocalAndExecutor
 * @description:
 * @author: CodingW
 * @create: 2025-01-17-22-07
 * @Version 1.0
 **/
public class TestInheritableThreadLocalAndExecutor implements Runnable {
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws Exception{
        System.out.println("----主线程启动");
        inheritableThreadLocal.set("主线程第一次赋值");
        System.out.println("----主线程设置后获取值：" + inheritableThreadLocal.get());
        executorService.submit(new TestInheritableThreadLocalAndExecutor());
        System.out.println("主线程休眠2秒");
        Thread.sleep(2000);
        inheritableThreadLocal.set("主线程第二次赋值");
        executorService.submit(new TestInheritableThreadLocalAndExecutor());
        executorService.shutdown();
    }

    @Override
    public void run() {
        System.out.println("----子线程获取值：" + inheritableThreadLocal.get());
    }
}