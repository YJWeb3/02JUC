package com.wclass.basic.d4_method.d4_thread_pool.d2_task_executor.server;

import com.wclass.basic.d4_method.d4_thread_pool.d2_task_executor.starter.ServerStarter;
import org.springframework.stereotype.Component;

/**
 * @projectName: 02JUC
 * @ClassName Server
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.16:15
 * @Version 1.0
 **/
//实际开发
@Component
public class Server {

    public Server(ServerStarter starter) {
        starter.startServer();
    }
}