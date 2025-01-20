package com.wclass.threadlocal.d3_transmittable_thread_local;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: 02JUC
 * @ClassName TransmittableThreadLocalDemo02
 * @description:
 * @author: CodingW
 * @create: 2025-01-17-22-19
 * @Version 1.0
 **/
public class TransmittableThreadLocalDemo02 {

    private static final TransmittableThreadLocal<Integer> tl = new TransmittableThreadLocal<>();

    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            2,
            2,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100)
    );

    public static void main(String[] args) {
        // 父线程设置变量 1
        tl.set(1);        poolExecutor.execute(() -> {
            // 更改当前线程中的值
            tl.set(2);
            System.out.println(String.format("子线程：%s，获取值=%s", Thread.currentThread().getName(), tl.get()));
        });
        poolExecutor.execute(() -> {
            System.out.println(String.format("子线程：%s，获取值=%s", Thread.currentThread().getName(), tl.get()));
        });
        poolExecutor.execute(() -> {
            System.out.println(String.format("子线程：%s，获取值=%s", Thread.currentThread().getName(), tl.get()));
        });
        poolExecutor.execute(() -> {
            System.out.println(String.format("子线程：%s，获取值=%s", Thread.currentThread().getName(), tl.get()));
        });

    }

}