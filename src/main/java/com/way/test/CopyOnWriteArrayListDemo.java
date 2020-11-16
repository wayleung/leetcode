package com.way.test;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayleung
 * @description
 * @date 2020-08-12 17:27:25
 */
public class CopyOnWriteArrayListDemo {

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
            threadPool.execute(new MyTask2());
        }
        threadPool.shutdown();
    }
}

class MyTask2 implements Runnable{

    List list;
    Integer count;

    @SneakyThrows
    @Override
    public void run() {
    }
}
