package com.wclass.basic.d4_method.d4_thread_pool.d4_async.main;

import com.wclass.basic.d4_method.d4_thread_pool.d4_async.demo.AsyncDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @projectName: 02JUC
 * @ClassName Main
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:55
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) throws Exception {

        AsyncDemo asyncDemo = new AsyncDemo();
        try {
            for (int i = 0; i <= 20; i++) {
                asyncDemo.doTaskThree();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
