package com.wclass.basic.d5_api.d2_join.demo02;

public class Join extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}