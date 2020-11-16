package com.way.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wayleung
 * @description 给定两个数组，编写一个函数来计算它们的交集。     示例 1：  输入：nums1 = [1,2,2,1], nums2 = [2,2] 输出：[2] 示例 2：  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出：[9,4]    说明：  输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
 * @date 2020-11-02 09:48:38
 */
public class Test349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
//        int[] common;
//
//        if(nums1.length<=nums2.length){
//            common = new int[nums1.length];
//        }else{
//            common = new int[nums2.length];
//        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    set.add(nums1[i]);
                }
            }
        }

        return set.stream().mapToInt(Number::intValue).toArray();
    }


}
