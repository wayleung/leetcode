package com.way.test;

import lombok.SneakyThrows;

/**
 * @author wayleung
 * @description
 * @date 2020-08-08 15:00:32
 */
public class Test {


    public static void main(String[] args) {
        new Thread(new Runnable() {

            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(100000000);
            }
        }).start();
    }
}
