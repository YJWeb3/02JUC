package com.wclass.basic.d5_api.currentthread;

public class CurrentthreadDemo {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
