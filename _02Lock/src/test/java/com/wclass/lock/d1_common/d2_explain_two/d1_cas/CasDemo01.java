package com.wclass.lock.d1_common.d2_explain_two.d1_cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: 02JUC
 * @ClassName CasDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.14:37
 * @Version 1.0
 **/
public class CasDemo01 {

    // 创建原子整数对象
    private static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                i.getAndIncrement();  // 获取并且自增  i++
            }
        });

        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                i.getAndDecrement(); // 获取并且自减  i--
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
