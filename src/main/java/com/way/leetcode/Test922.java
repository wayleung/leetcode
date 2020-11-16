package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-11-12 13:24:36
 */
public class Test922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] odd = new int[A.length/2];
        int oddIndex = 0;
        int evenIndex = 0;
        int[] even = new int[A.length/2];
        for(int item:A){
            if(item%2==0){
                even[evenIndex++] = item;
            }else{
                odd[oddIndex++] = item;
            }
        }
        oddIndex = 0;
        evenIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if(i%2==0){
                A[i] = even[evenIndex++];
            }else{
                A[i] = odd[oddIndex++];
            }
        }

        return A;
    }
}
