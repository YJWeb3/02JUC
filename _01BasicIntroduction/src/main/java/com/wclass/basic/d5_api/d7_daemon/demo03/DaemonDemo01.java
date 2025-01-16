package com.wclass.basic.d5_api.d7_daemon.demo03;

public class DaemonDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
