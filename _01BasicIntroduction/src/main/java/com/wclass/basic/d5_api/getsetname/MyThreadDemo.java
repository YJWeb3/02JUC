package com.wclass.basic.d5_api.getsetname;

/*
    Thread类中获取和设置线程名称的方法
        void setName(String name)：将此线程的名称更改为等于参数 name
        String getName()：返回此线程的名称
 */
public class MyThreadDemo {
    public static void main(String[] args) {
//        MyThreadLamdaDemo my1 = new MyThreadLamdaDemo();
//        MyThreadLamdaDemo my2 = new MyThreadLamdaDemo();
//
//        //void setName(String name)：将此线程的名称更改为等于参数 name
//        my1.setName("高铁");
//        my2.setName("飞机");

        //Thread(String name)
//        MyThreadLamdaDemo my1 = new MyThreadLamdaDemo("高铁");
//        MyThreadLamdaDemo my2 = new MyThreadLamdaDemo("飞机");
//
//        my1.start();
//        my2.start();

        //static Thread currentThread() 返回对当前正在执行的线程对象的引用
        System.out.println(Thread.currentThread().getName());
    }
}
