package com.wclass.basic.d5_api.d6_interrupts.demo01;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @projectName: 02JUC
 * @ClassName InterruptDemo05
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.13:44
 * @Version 1.0
 **/
class InterruptDemo05 extends Thread {
    volatile ServerSocket socket;

    public static void main(String args[]) throws Exception {
        InterruptDemo05 thread = new InterruptDemo05();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        Thread.currentThread().interrupt();// 再调用interrupt方法
        thread.socket.close();// 再调用close方法
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("Stopping application...");
    }

    public void run() {
        try {
            socket = new ServerSocket(8888);
        } catch (IOException e) {
            System.out.println("Could not create the socket...");
            return;
        }
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Waiting for connection...");
            try {
                socket.accept();
            } catch (IOException e) {
                System.out.println("accept() failed or interrupted...");
                Thread.currentThread().interrupt();//重新设置中断标示位
            }
        }
        System.out.println("Thread exiting under request...");
    }
}