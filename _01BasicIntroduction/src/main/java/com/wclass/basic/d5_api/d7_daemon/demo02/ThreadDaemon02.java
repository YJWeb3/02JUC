package com.wclass.basic.d5_api.d7_daemon.demo02;

public class ThreadDaemon02 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "---" + i);
        }
    }
}
