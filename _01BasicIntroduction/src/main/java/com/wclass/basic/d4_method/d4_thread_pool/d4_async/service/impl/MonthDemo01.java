package com.wclass.basic.d4_method.d4_thread_pool.d4_async.service.impl;

import com.wclass.basic.d4_method.d4_thread_pool.d4_async.mapper.BaseMapper;
import com.wclass.basic.d4_method.d4_thread_pool.d4_async.service.MonthDemo;
import com.wclass.basic.d4_method.d4_thread_pool.d4_async.test.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: 02JUC
 * @ClassName Test01
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:58
 * @Version 1.0
 **/
public class MonthDemo01 implements MonthDemo {

    @Autowired
    private Test test;

    BaseMapper baseMapper = new BaseMapper();
    @Override
    public List<Integer> findByMonth() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            int count = baseMapper.findByMonth(i);
            list.add(count);
        }
        System.out.println("开始执行多线程任务1111111111:::" + System.currentTimeMillis());
        for (int i = 0; i <= 5; i++) {
            test.doTaskThree(i);
        }
        System.out.println("主线程继续执行222222222222222:::::" + Thread.currentThread().getName());
        return list;
    }

}
