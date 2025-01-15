package com.wclass.basic.d4_method.d4_thread_pool.d2_task_executor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @projectName: 02JUC
 * @ClassName ExecturConfig
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:11
 * @Version 1.0
 **/
@EnableAsync
@Configuration
public class ExecturConfig {
    @Bean("taskExecutor")
    public Executor taskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int i = Runtime.getRuntime().availableProcessors();//获取到服务器的cpu内核
        executor.setCorePoolSize(10);//核心池大小
        //executor.setMaxPoolSize(100);//最大线程数
        //executor.setQueueCapacity(1000);//队列程度
        //executor.setKeepAliveSeconds(1000);//线程空闲时间
        //executor.setThreadNamePrefix("tsak-asyn");//线程前缀名称
        //executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//配置拒绝策略
        return executor;
    }
}