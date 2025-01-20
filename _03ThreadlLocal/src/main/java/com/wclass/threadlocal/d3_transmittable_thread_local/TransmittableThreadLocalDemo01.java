package com.wclass.threadlocal.d3_transmittable_thread_local;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @program: 02JUC
 * @ClassName TransmittableThreadLocalDemo01
 * @description:
 * @author: CodingW
 * @create: 2025-01-17-22-17
 * @Version 1.0
 **/
public class TransmittableThreadLocalDemo01 {

    // TTL
    private static final TransmittableThreadLocal<Integer> tl = new TransmittableThreadLocal<>();
    public static void main(String[] args) {
        // 父线程设置变量 1
        tl.set(1);
        new Thread(() -> {
            System.out.println(String.format("子线程：%s，获取值=%s", Thread.currentThread().getName(), tl.get()));
        }).start();
        new Thread(() -> {
            System.out.println(String.format("子线程：%s，获取值=%s", Thread.currentThread().getName(), tl.get()));
        }).start();
    }

}