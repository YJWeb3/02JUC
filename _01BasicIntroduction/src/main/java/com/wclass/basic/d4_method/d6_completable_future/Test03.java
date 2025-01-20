package com.wclass.basic.d4_method.d6_completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * @program: 02JUC
 * @ClassName Test03
 * @description:
 * @author: CodingW
 * @create: 2025-01-16-00-08
 * @Version 1.0
 **/
public class Test03 {

    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        try {
            System.out.println("cf1结果->" + cf1.get());
            //等待任务2执行完成
            System.out.println("cf2结果->" + cf2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    public static void test02(){
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApply((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        try {
            System.out.println("cf1结果->" + cf1.get());
            //等待任务2执行完成
            System.out.println("cf2结果->" + cf2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}