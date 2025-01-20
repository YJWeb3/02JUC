package com.wclass.threadlocal.d1_threadlocal.demo01;

/**
 * @projectName: 02JUC
 * @ClassName ThreadLocalDemo02
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.15:30
 * @Version 1.0
 **/
public class ThreadLocalDemo02 {

    public static void main(String[] args) {
        User user = new User("jack");
        new Service1().service1(user);
    }

}

class Service1 {
    public void service1(User user){
        //给ThreadLocal赋值，后续的服务直接通过ThreadLocal获取就行了。
        UserContextHolder.holder.set(user);
        new Service2().service2();
    }
}

class Service2 {
    public void service2(){
        User user = UserContextHolder.holder.get();
        System.out.println("service2拿到的用户:"+user.name);
        new Service3().service3();
    }
}

class Service3 {
    public void service3(){
        User user = UserContextHolder.holder.get();
        System.out.println("service3拿到的用户:"+user.name);
        //在整个流程执行完毕后，一定要执行remove
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    //创建ThreadLocal保存User对象
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
    String name;
    public User(String name){
        this.name = name;
    }
}