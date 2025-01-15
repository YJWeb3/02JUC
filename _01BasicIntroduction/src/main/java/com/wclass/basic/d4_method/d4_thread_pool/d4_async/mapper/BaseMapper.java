package com.wclass.basic.d4_method.d4_thread_pool.d4_async.mapper;

/**
 * @projectName: 02JUC
 * @ClassName BaseMapper
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.17:09
 * @Version 1.0
 **/

public class BaseMapper {

    public int findByMonth(int month){
        return month - 1;
    }
}
