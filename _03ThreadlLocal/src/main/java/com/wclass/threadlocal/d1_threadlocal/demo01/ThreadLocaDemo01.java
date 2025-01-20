package com.wclass.threadlocal.d1_threadlocal.demo01;

/**
 * @projectName: 02JUC
 * @ClassName ThreadLocaDemo01
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.15:14
 * @Version 1.0
 **/
public class ThreadLocaDemo01 {

    private static ThreadLocal<String> localVar = new ThreadLocal<String>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                ThreadLocaDemo01.localVar.set("local_A");
                print("A");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());

            }
        },"A").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            public void run() {
                ThreadLocaDemo01.localVar.set("local_B");
                print("B");
                System.out.println("after remove : " + localVar.get());

            }
        },"B").start();
    }

}
