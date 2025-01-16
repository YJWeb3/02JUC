package com.wclass.basic.d5_api.d7_daemon.demo04;

import java.io.IOException;

public class DaemonDemo01 extends Thread {
	// 永真循环线程
	public void run() { 
		for (int i = 0;; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println("异常。。。。");
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		DaemonDemo01 test = new DaemonDemo01();
		// 调试时可以设置为false，那么这个程序是个死循环，没有退出条件。设置为true，即可主线程结束，test线程也结束。
		test.setDaemon(true); 
		test.start();
		System.out.println("isDaemon = " + test.isDaemon());
		try {
			// 接受输入，使程序在此停顿，一旦接收到用户输入，main线程结束，守护线程自动结束
			System.in.read(); 
		} catch (IOException ex) {
		}
	}
}