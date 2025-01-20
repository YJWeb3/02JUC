package com.wclass.basic.d5_api.d6_interrupts.demo02;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:MyCallableLambdaDemo
 * Package:PACKAGE_NAME
 * Description:描述
 *
 * @Date:2022/7/15 15:24
 * @Author:CodingW
 * @Version:1.0
 */
public class InterruptDemo02 {
	public static void main(String[] args) {
		InterruptDemo02_Test dt = new InterruptDemo02_Test();
		dt.start();
		try {
			TimeUnit.SECONDS.sleep(3);
			dt.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class InterruptDemo02_Test {
    private Thread monitor; // 监视线程
    public void start(){
        monitor = new Thread( () -> {
            while ( true ){
                if ( Thread.currentThread().isInterrupted() ){ // 如果当前线程被打断,这安排后事退出
                    System.out.println(System.currentTimeMillis() + " - 被打断,开始安排后事...");
                    break;
                }
                try {
                    // 如果在休眠期间被打断,那么会抛出异常,抛出异常后打断状态被重置为false,而导致程序不会被终止
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(System.currentTimeMillis() + " - 执行监控...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt(); // 重新打断一下
                }
            }
        });

        monitor.start();
    }

    public void stop(){
        monitor.interrupt();// 打断
    }
}
