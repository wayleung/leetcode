package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-18 21:38:32
 */
public class Test1114 {
    public static void main(String[] args) {

    }
}


class Foo {

    private static int index = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (index == 0) {
                this.wait();
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                index=1;
                this.notifyAll();
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (index == 1) {
                this.wait();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                index=2;
                this.notifyAll();
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (index == 2) {
                this.wait();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                index=-1;
                this.notifyAll();
                break;
            }
        }
    }
}