package com.way.test;

/**
 * @author wayleung
 * @description
 * @date 2020-08-12 13:31:54
 */
public class TestCpu {

    public static void main(String[] args) throws InterruptedException {
        new TestCpu().testCPULoop();
    }

    public void testCPULoop() throws InterruptedException {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }

    }
}
