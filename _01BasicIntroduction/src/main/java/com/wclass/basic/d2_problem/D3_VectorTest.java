package com.wclass.basic.d2_problem;

import java.util.Vector;

/**
 * @projectName: 02JUC
 * @ClassName D3_VectorTest
 * @description:
 * @author: CodingW
 * @create: 2025.01.15.15:14
 * @Version 1.0
 **/
public class D3_VectorTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20) {
            }
        }
    }

    public static void test02() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20) {
            }
        }
    }
}
