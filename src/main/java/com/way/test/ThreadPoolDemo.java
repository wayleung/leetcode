package com.way.test;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayleung
 * @description
 * @date 2020-08-12 16:54:22
 */
public class ThreadPoolDemo {
    public static final Integer CORE_POOL_SIZE = 5;
    public static final Integer MAX_POOL_SIZE = 5;
    private static final int QUEUE_CAPACITY = 1;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
//        ThreadPoolExecutor threadPool  = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY));
//        ThreadPoolExecutor threadPool  = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,  new SynchronousQueue<Runnable>());
//        ThreadPoolExecutor threadPool  = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 7; i++) {
            threadPool.execute(new MyTask());
        }
        threadPool.shutdown();
    }
}


class MyTask implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(3000);
    }
}