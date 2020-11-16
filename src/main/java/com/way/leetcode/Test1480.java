package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-18 22:03:43
 */
public class Test1480 {

}


class Solution {
    public int[] runningSum(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total  + nums[i];
            nums[i] = total;
        }
        return nums;
    }
}
