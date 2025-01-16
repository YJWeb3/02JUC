package com.wclass.basic.d5_api.d7_daemon.demo01;

/**
 * @projectName: 02JUC
 * @ClassName DaemonDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.13:47
 * @Version 1.0
 **/
public class DaemonDemo02 {
    public static void main(String[] args){
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int sum = 0;
                for (int i = 1; i  <= 100; i++) {
                    sum = sum + i;
                }
                System.out.println("守护线程，最终求和的值为： " + sum);
            }
        });
        threadOne.setDaemon(true); //设置threadOne为守护线程
        threadOne. start();
        System.out.println("main 函数线程执行完毕， JVM 退出。");
    }
}