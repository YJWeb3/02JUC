package com.wclass.basic.d5_api.daemon.test02;

public class DaemonDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
