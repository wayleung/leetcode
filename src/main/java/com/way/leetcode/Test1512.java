package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-18 22:51:25
 */
public class Test1512 {

    public static void main(String[] args) {

    }

    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length-1; j++) {
                if(nums[i] == nums[j]){
                    result++;
                }
            }
        }
        return result;
    }
}
