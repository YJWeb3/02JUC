package com.wclass.basic.d5_api.d7_daemon.demo01;

/**
 * @projectName: 02JUC
 * @ClassName DaemonDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.13:47
 * @Version 1.0
 **/
public class DaemonDemo01 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //代码执行逻辑
            }
        });
        threadOne.setDaemon(true); //设置threadOne为守护线程
        threadOne. start();
    }
}
