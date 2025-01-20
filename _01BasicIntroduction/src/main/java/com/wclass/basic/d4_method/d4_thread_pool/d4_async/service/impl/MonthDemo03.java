package com.wclass.basic.d4_method.d4_thread_pool.d4_async.service.impl;

import com.wclass.basic.d4_method.d4_thread_pool.d4_async.mapper.BaseMapper;
import com.wclass.basic.d4_method.d4_thread_pool.d4_async.test.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @projectName: 02JUC
 * @ClassName MonthDemo03
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.17:18
 * @Version 1.0
 **/
public class MonthDemo03 {

    @Autowired
    private Test test;

    public void findByMonth() {
        System.out.println("开始执行多线程任务1111111111:::" + System.currentTimeMillis());
        List<Future<String>> list1 = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            Future<String> stringFuture = test.doTaskThree02(i);
            list1.add(stringFuture);
        }
        boolean flag = false;
        while (!flag) {
            for (Future<String> future : list1) {
                try {
                    String s = future.get();
                    if (s == "成功") {
                        flag = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("主线程继续执行222222222222222:::::" + Thread.currentThread().getName());

    }

}
