package com.way.test;

/**
 * @author wayleung
 * @description
 * @date 2020-08-12 23:02:25
 */
//public class ThreadLocalDemo {
//
//    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(new Integer(1));
//
//    public static void main(String[] args) {
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,5,1L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1));
//        for (int i = 0; i < 100; i++) {
//            threadPool.execute(new MyTask3());
//        }
//
//    }
//}
//
//
//class MyTask3 implements Runnable{
//
//
//
//    @SneakyThrows
//    @Override
//    public void run() {
//        Integer integer = ThreadLocalDemo.threadLocal.get();
//        integer++;
//    }
//}

