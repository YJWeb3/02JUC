package com.wclass.basic.d5_api.d4_yield;

/**
 * @projectName: 02JUC
 * @ClassName YieldDemo
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.11:09
 * @Version 1.0
 **/
public class YieldDemo {

    public static void main(String[] args) {
        YieldTest t1 = new YieldTest();
        YieldTest t2 = new YieldTest();

        Thread th1 = new Thread(t1,"a");
        Thread th2 = new Thread(t2,"b");
        /*
         * 设置线程的优先级相同, 原因：优先级高的yield下次运行仍然先于优先级低的
         */
        th2.setPriority(Thread.MAX_PRIORITY);
        th1.setPriority(Thread.MIN_PRIORITY);

        th1.start();
        th2.start();

    }
}

class YieldTest implements Runnable{
    @Override
    public void run() {
        if ( "a".equals(Thread.currentThread().getName())){
   /*         try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            Thread.yield(); // 不能指定时间,就是让出当前线程的cpu执行权，使得线程由运行状态变为就绪状态,等下调用时再执行
        }

        for (int i = 0;i < 10;++ i){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
