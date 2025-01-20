package com.wclass.basic.d4_method.d2_runnable;

/**
 * @projectName: 02JUC
 * @ClassName MyRunnableDemo
 * @description: 创建线程方式二：实现Runnable接口
 * @author: CodingW
 * @create: 2025.01.15.16:05
 * @Version 1.0
 **/
public class MyRunnableDemo {

    public static void main(String[] args) {
        // 3. 创建一个任务对象
        Runnable target = new MyRunnable();
        // 4. 把任务对象交给Thread处理
        Thread t = new Thread(target);
        // Thread t = new Thread(target, "yjxz1");
        // 5. 启动线程
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 主线程输出：" + i);
        }
    }
}

/**
 1.定义一个线程任务类 实现Runnable接口
 */
class MyRunnable  implements Runnable {
    /**
     2. 重写run方法，定义线程的执行任务的
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 子线程输出：" + i);
        }
    }
}