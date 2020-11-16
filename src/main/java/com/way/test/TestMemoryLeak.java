package com.way.test;

/**
 * @author wayleung
 * @description
 * @date 2020-08-12 13:35:29
 */
public class TestMemoryLeak {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            Thread.sleep(2000);
            new TestMemoryLeak().leak();
        }

    }

    public String leak() {
        System.out.println("模拟内存泄漏");
        ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();
        localVariable.set(new Byte[4096 * 1024]);// 为线程添加变量
        return "ok";
    }
}
