package com.way.test;

/**
 * @author wayleung
 * @description
 * @date 2020-08-08 21:20:20
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024+"M");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024+"M");
    }
}
