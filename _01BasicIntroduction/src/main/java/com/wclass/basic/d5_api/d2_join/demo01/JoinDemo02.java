package com.wclass.basic.d5_api.d2_join.demo01;

/**
 * @projectName: 02JUC
 * @ClassName JoinDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.10:57
 * @Version 1.0
 **/
public class JoinDemo02 {
    private static final int TIMES = 100;
    private class JoinThread extends Thread {
        JoinThread(String name){
            super(name);
        }
        @Override
        public void run() {
            for (int i = 0; i < TIMES; i++) {
                System.out.println(getName() + " " + i);
            }
        }
    }

    public static void main(String[] args) {
        JoinDemo02 example = new JoinDemo02();
        example.test();
    }
    private void test() {
        for (int i = 0; i < TIMES; i++) {
            if (i == 20) {
                Thread jt1 = new JoinThread("子线程1");
                Thread jt2 = new JoinThread("子线程2");
                jt1.start();
                jt2.start();
                // main 线程调用了jt1线程和jt2线程的join()方法
                // main 线程必须等到 jt1和jt2线程 执行完之后才会向下执行
                try {
                    // 需要等到jt1执行完成之后，才向下执行。在jt1没有执行完期间，其他线程无法运行。
                    jt1.join();
                    // 需要等到jt2执行完成之后，才向下执行。在jt2没有执行完期间，其他线程无法运行。
                    jt2.join();
                    // join还存在可以传入时间参数的方法：join(long mills) - 等待时间内被join的线程还没执行，就不再等待，继续向下执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}