package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-19 00:05:11
 */
public class Test1470 {
    public static void main(String[] args) {
        System.out.println(new Test1470().shuffle(new int[]{2, 5, 1, 3, 4, 7, 0}, 3));

    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                result[i] = nums[i/2];
            }else{
                result[i] = nums[i/2+n];
            }
        }
        return result;
    }
}
