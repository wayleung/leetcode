package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-19 08:49:27
 */
public class Test1486 {
    public static void main(String[] args) {
        System.out.println(new Test1486().xorOperation(5, 0));
    }

    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i <n; i++) {
            result =  result^(start+i*2);
        }
        return result;
    }
}
