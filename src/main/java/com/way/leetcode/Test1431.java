package com.way.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wayleung
 * @description
 * @date 2020-08-18 22:22:56
 */
public class Test1431 {
    public static void main(String[] args) {
        System.out.println(new Test1431().kidsWithCandies(new int[]{2, 8, 7}, 1));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int maxValue = findMaxValue(candies);
        for (int i = 0; i < candies.length; i++) {
            if(candies[i]+extraCandies>=maxValue){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }

    public int findMaxValue(int[] candies){
        int maxValue = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if(maxValue<candies[i]){
                maxValue = candies[i];
            }
        }
        return maxValue;
    }
}

class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int maxValue = findMaxValue(candies);
        for (int i = 0; i < candies.length; i++) {
            if(candies[i]+extraCandies>=maxValue){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }

    public int findMaxValue(int[] candies){
        for (int i = 0; i < candies.length; i++) {
            for (int j = i+1; j < candies.length-1; j++) {
                if(candies[j]>candies[i]){
                    int temp = candies[j];
                    candies[j] = candies[i];
                    candies[i] = temp;
                }
            }
        }
        return candies[0];
    }
}
