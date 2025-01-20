package com.wclass.basic.d5_api.d2_join.demo02;

/*
    void join()：等待这个线程死亡
 */
public class JoinDemo {
    public static void main(String[] args) {
        Join tj1 = new Join();
        Join tj2 = new Join();
        Join tj3 = new Join();

        tj1.setName("康熙");
        tj2.setName("四阿哥");
        tj3.setName("八阿哥");

        tj1.start();
        try {
            tj1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tj2.start();
        tj3.start();
    }
}
