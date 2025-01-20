package com.wclass.basic.d4_method.d6_completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: 02JUC
 * @ClassName Test01
 * @description:
 * @author: CodingW
 * @create: 2025-01-16-00-04
 * @Version 1.0
 **/
public class Test01 {

    public static void main(String[] args){
        test01();
    }

    public static void test01() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something....");
            return "result";
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

    public static void test02() {
        // 自定义线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something....");
            return "result";
        }, executorService);

        //等待子任务执行完成
        try {
            System.out.println("结果->" + cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}