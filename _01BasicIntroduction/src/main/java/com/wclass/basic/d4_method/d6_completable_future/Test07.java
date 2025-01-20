package com.wclass.basic.d4_method.d6_completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: 02JUC
 * @ClassName Test07
 * @description:
 * @author: CodingW
 * @create: 2025-01-16-00-13
 * @Version 1.0
 **/
public class Test07 {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            // int a = 1/0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.handle((result, e) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            return result+2;
        });

        //等待任务2执行完成
        try {
            System.out.println("cf2结果->" + cf2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}