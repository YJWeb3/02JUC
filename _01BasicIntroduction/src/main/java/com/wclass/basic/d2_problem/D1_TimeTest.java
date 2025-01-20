package com.wclass.basic.d2_problem;

/**
 * @projectName: 02JUC
 * @ClassName D1_TimeTest
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.15:03
 * @Version 1.0
 **/
public class D1_TimeTest {
    public final int count = 1000000;

    public static void main(String[] args) throws InterruptedException {
        D1_TimeTest D1_TimeTest = new D1_TimeTest();
        System.out.println("执行 " + D1_TimeTest.count + " 次");
        D1_TimeTest.serial();	//串行
        D1_TimeTest.parallel();	//并行
    }

    public void serial() {
        int a = 0;
        int b = 0;
        long l = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            a++;
        }

        for (int i = 0; i < count; i++) {
            b--;
        }

        System.out.println("串行----->" + (System.currentTimeMillis() - l));
    }

    public void parallel() throws InterruptedException {
        int b = 0;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        });
        long l = System.currentTimeMillis();
        thread.start();
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();	//等thread线程执行完毕再输出时间差
        System.out.println("并行----->" + (System.currentTimeMillis() - l));
    }
}