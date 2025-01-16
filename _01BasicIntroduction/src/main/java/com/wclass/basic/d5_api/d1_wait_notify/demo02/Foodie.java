package com.wclass.basic.d5_api.d1_wait_notify.demo02;

/**
 * @projectName: 02JUC
 * @ClassName Foodie
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.10:51
 * @Version 1.0
 **/
public class Foodie extends Thread {
    @Override
    public void run() {
//        1，判断桌子上是否有汉堡包。
//        2，如果没有就等待。
//        3，如果有就开吃
//        4，吃完之后，桌子上的汉堡包就没有了
//                叫醒等待的生产者继续生产
//        汉堡包的总数量减一

        //套路:
        //1. while(true)死循环
        //2. synchronized 锁,锁对象要唯一
        //3. 判断,共享数据是否结束. 结束
        //4. 判断,共享数据是否结束. 没有结束
        while(true){
            synchronized (Desk.lock){
                if(Desk.count == 0){
                    break;
                }else{
                    if(Desk.flag){
                        //有
                        System.out.println("吃货在吃汉堡包");
                        Desk.flag = false;
                        Desk.lock.notifyAll();
                        Desk.count--;
                    }else{
                        //没有就等待
                        //使用什么对象当做锁,那么就必须用这个对象去调用等待和唤醒的方法.
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}