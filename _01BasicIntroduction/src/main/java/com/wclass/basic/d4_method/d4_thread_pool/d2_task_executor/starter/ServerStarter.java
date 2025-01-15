package com.wclass.basic.d4_method.d4_thread_pool.d2_task_executor.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @projectName: 02JUC
 * @ClassName ServerStarter
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:14
 * @Version 1.0
 **/
@Component
public class ServerStarter{
//    @Resource(name = "taskExecutor")
//    ThreadPoolTaskExecutor taskExecutor;
    // 或者可以直接@Autowried
    @Autowired
    ThreadPoolTaskExecutor taskExecutor;

    @Async("taskExecutor")
    public void startServer(){
        //业务逻辑
    }
}
