package com.wclass.basic.d4_method.d3_future_task;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @projectName: 02JUC
 * @ClassName MyCallableDemo
 * @description: 创建方式三：实现Callable接口，结合FutureTask完成
 * @author: CodingW
 * @create: 2025.01.15.16:06
 * @Version 1.0
 **/
public class MyCallableDemo {

    public static void main(String[] args) {
        // 3. 创建Callable任务对象
        Callable<String> call = new MyCallable(100);
        // 4. 把Callable任务对象 交给 FutureTask 对象
        //  FutureTask对象的作用1： 是Runnable的对象（实现了Runnable接口），可以交给Thread了
        //  FutureTask对象的作用2： 可以在线程执行完毕之后通过调用其get方法得到线程执行完成的结果
        FutureTask<String> f1 = new FutureTask<>(call);
        // 5、FutureTask 对象交给线程处理
        Thread t1 = new Thread(f1);
        // 6、启动线程
        t1.start();


        Callable<String> call2 = new MyCallable(200);
        FutureTask<String> f2 = new FutureTask<>(call2);
        Thread t2 = new Thread(f2);
        t2.start();

        try {
            // 如果f1任务没有执行完毕，这里的代码会等待，直到线程1跑完才提取结果。
            String rs1 = f1.get();
            System.out.println("第一个结果：" + rs1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 如果f2任务没有执行完毕，这里的代码会等待，直到线程2跑完才提取结果。
            String rs2 = f2.get();
            System.out.println("第二个结果：" + rs2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 1. 定义一个任务类 实现Callable接口，并声明线程任务执行完毕后的结果的数据类型
 */
class MyCallable implements Callable<String> {
    private int num;
    public MyCallable(int n) {
        this.num = num;
    }

    /**
     2. 重写call方法（任务方法）
     */
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= num ; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + " 子线程执行的结果是：" + sum;
    }
}