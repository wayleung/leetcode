package com.way.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wayleung
 * @description
 * @date 2020-12-15 11:10:20
 */
public class Test26 {

    public static void main(String[] args) {
//        new Test26().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        new Test26().removeDuplicates(new int[]{1,1,2});
//        new Test26().removeDuplicates(new int[]{1,2});
//        new Test26().removeDuplicates(new int[]{1,1,1});
    }


//    public int removeDuplicates(int[] nums) {
//        // 使用双指针
//        if(nums==null || nums.length == 1){
//            return nums.length;
//        }
//        int i = 0,j =1;
//        while(j<nums.length){
//            if(nums[i]==nums[j]){
//                j++;
//            }else{
//                i++;
//                nums[i]=nums[j];
//                j++;
//            }
//        }
//        return i+1;
//    }

    public int removeDuplicates(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int repeatCount = 0;
        int index = 0;
        for (int i = 0; i < nums.length;i++) {
            int isRepeat = getRepeatCount(nums, nums[i], i);
            nums[index] = nums[i];
            if(isRepeat>0){
                repeatCount=repeatCount+isRepeat;
                i = i+isRepeat;
            }
            index++;
        }
        return nums.length-repeatCount;
    }

    int getRepeatCount(int[] nums,int num,int index){
        int repeatCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==num&&index!=i){
                repeatCount++;
            }
        }
        return repeatCount;
    }
}
