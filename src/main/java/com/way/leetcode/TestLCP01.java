package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-24 14:43:27
 */
public class TestLCP01 {
    public static void main(String[] args) {

    }

    public int game(int[] guess, int[] answer) {
        int result = 0;
        for (int i = 0; i < guess.length; i++) {
            if(guess[i]==answer[i]){
                result++;
            }
        }
        return result;
    }
}
