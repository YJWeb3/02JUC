package com.wclass.basic.d4_method.d6_completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: 02JUC
 * @ClassName Test02
 * @description:
 * @author: CodingW
 * @create: 2025-01-16-00-06
 * @Version 1.0
 **/
public class Test02 {

    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        });

        //等待任务执行完成
        try {
            System.out.println("结果->" + cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void test02(){
        // 自定义线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        }, executorService);

        //等待任务执行完成
        try {
            System.out.println("结果->" + cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}