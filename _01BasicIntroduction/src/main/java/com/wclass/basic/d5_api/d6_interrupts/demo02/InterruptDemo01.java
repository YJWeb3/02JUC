package com.wclass.basic.d5_api.d6_interrupts.demo02;

public class InterruptDemo01 {
    static class MyRunnable implements Runnable {

        public void run() {
            for (int i = 0; i < 50000; i++) {
                System.out.println("i=" + (i + 1));
            }
        }

    }
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
        t.interrupt();
        System.out.println(t.isInterrupted());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.isInterrupted());
    }
}