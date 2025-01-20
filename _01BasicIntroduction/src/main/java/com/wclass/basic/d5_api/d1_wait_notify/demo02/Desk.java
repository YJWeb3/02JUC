package com.wclass.basic.d5_api.d1_wait_notify.demo02;

/**
 * @projectName: 02JUC
 * @ClassName Desk
 * @description:
 * @author: CodingW
 * @create: 2025.01.16.10:51
 * @Version 1.0
 **/
public class Desk {

    //定义一个标记
    //true 就表示桌子上有汉堡包的,此时允许吃货执行
    //false 就表示桌子上没有汉堡包的,此时允许厨师执行
    public static boolean flag = false;

    //汉堡包的总数量
    public static int count = 10;

    //锁对象
    public static final Object lock = new Object();
}
