package com.wclass.lock.d3_related_classes.d4_stamped_lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @projectName: 02JUC
 * @ClassName Point
 * @description:
 * @author: CodingW
 * @create: 2025.01.17.15:08
 * @Version 1.0
 **/
public class Point {
    // 成员变量
    private double x, y;

    // 锁实例
    private final StampedLock sl = new StampedLock();
    // 排它锁---写锁（writeLock)
    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        }finally {
            sl.unlockWrite(stamp);
        }
    }

    // 乐观锁(tryOptimisticRead)
    double distanceFromOrigin() {
        // 尝试获取乐观读锁
        long stamp = sl.tryOptimisticRead();
        // 将全部方法复制到方法体栈内
        double currentX = x, currentY = y;
        // 检查读锁戳记，锁有没有被其他写线程排他性抢占
        if (!sl.validate(stamp)) {
            // 如果抢占则获取一个共享读锁
            stamp = sl.readLock();
            try {
                // 将全部变量复制到方法体栈内
                currentX = x;
                currentY = y;
            }finally {
                // 释放共享锁
                sl.unlockRead(stamp);
            }
        }
        // 返回计算结果
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    // 使用悲观锁获取锁，并尝试转换为写锁
    void moveIfAtOrigin(double newX, double newY) {
        // 这里可以使用乐观读锁替换
        long stamp = sl.readLock();

        try {
            // 如果当前点在原点则移动
            while (x == 0.0 && y == 0.0) {
                // 尝试将获取的读锁升级为写锁
                long ws = sl.tryConvertToWriteLock(stamp);
                // 升级成功，则更新戳记，并设置坐标值，然后退出循环
                if (ws != 0L) {
                    stamp  = ws;
                    x = newX;
                    y = newY;
                    break;
                }else {
                    // 读锁升级写锁失败，释放读锁，显示获取独占写锁，然后循环重试
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        }finally {
            // 释放锁
            sl.unlock(stamp);
        }
    }
}
