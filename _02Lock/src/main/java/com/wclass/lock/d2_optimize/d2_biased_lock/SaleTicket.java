package com.wclass.lock.d2_optimize.d2_biased_lock;

/**
 * @projectName: 02JUC
 * @ClassName SaleTicket
 * @description: 实现3个售票员卖出50张票的案例
 * @author: CodingW
 * @create: 2025.01.17.14:00
 * @Version 1.0
 **/
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            //循环100次保证能够卖光票
            for (int i = 0; i < 100; i++) {
                ticket.saleTicket();
            }
        }, "T1").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.saleTicket();
            }
        }, "T2").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.saleTicket();
            }
        }, "T3").start();
    }
}

/**
 * @description: 资源类
 */
class Ticket {
    private int count = 50;

    public synchronized void saleTicket() {
        if (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName() + "卖票成功，还剩" + count + "张票！");
        }
    }
}
