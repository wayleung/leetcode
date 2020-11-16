package com.way.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangliwei 80551025
 * @description 7
 * @date 2019-11-15
 */
public class Test7 {
    public static void main(String[] args) {
        System.out.println(new Test7().reverse(1534236469));
    }


    public int reverse(int x) {
        List<Integer> resultList = new ArrayList<>();
        while (x!=0){
            resultList.add(getTensAndSingle(x)[1]);
            x = getTensAndSingle(x)[0];
        }
        double total=0;
        for (int i=0;i<resultList.size();i++){
            int item = resultList.get(i);
            double digit = Math.pow(10, resultList.size() - 1 - i);
            total = total+item*digit;
        }
        return (int)total;
    }

    /**
     * 获取十位数前的数字和个位数
     */
    public int[] getTensAndSingle(int x){
        int single = x % 10;
        int tens = x / 10;
        return new int[]{tens,single};
    }
}
