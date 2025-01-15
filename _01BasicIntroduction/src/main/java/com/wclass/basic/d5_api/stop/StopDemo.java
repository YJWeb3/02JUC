package com.wclass.basic.d5_api.stop;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class StopDemo {
    public static void main(String[] args) {
        StopThread thread = new StopThread();
        // 多线程开启
        thread.start();
        try {
            // 主线程休眠 10 ms
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // 作为例子就直接打印到控制台了
            e.printStackTrace();
        }
        // 暂停线程
        thread.stop();
        // 线程是否存活状态
        while (thread.isAlive()) {
        }
    }

    private static class StopThread extends Thread {
        private int i = 0;

        @Override
        public void run() {
            synchronized (this) {// 增加同步锁，确保线程安全
                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("stopdemo.txt", true)));
                    while (i < 10) {
                        // 写入一次，休眠 10 ms
                        out.write("写入" + i + "\r\n");
                        i++;
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        // 断言输出流out不为null，就将输出流out流关闭，如果为输出流out为null，则会抛出一个AssertionError对象！
                        assert out != null;
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}