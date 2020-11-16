package com.way.leetcode;

/**
 * @author wayleung
 * @description 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：  A.length >= 3 在 0 < i < A.length - 1 条件下，存在 i 使得： A[0] < A[1] < ... A[i-1] < A[i] A[i] > A[i+1] > ... > A[A.length - 1]
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-mountain-array 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-11-03 13:47:51
 *
 * 执行用时：
 * 2 ms
 * , 在所有 Java 提交中击败了
 * 41.65%
 * 的用户
 * 内存消耗：
 * 39.2 MB
 * , 在所有 Java 提交中击败了
 * 98.11%
 * 的用户
 */
public class Test941 {
    public static void main(String[] args) {
//        int[] a = new int[]{0,3,2,1};
        int[] a = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println(new Test941().validMountainArray(a));
    }


    //反向思维 排除法 找出不是山脉数组的条件 剩下的就是就是山脉数组
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }
        int maxIndex = findMaxIndex(A);
        if(maxIndex<1||maxIndex>=A.length-1){
            return false;
        }
        for (int i = 0; i < maxIndex; i++) {
            if(A[i+1]<=A[i]){
                return false;
            }
        }
        for (int i = maxIndex; i < A.length-1; i++) {
            if(A[i+1]>=A[i]){
                return false;
            }
        }
        return true;
    }


    public int findMaxIndex(int[] A){
        int max = -1;
        int maxIndex= -1;
        for (int i = 0; i < A.length; i++) {
            if(A[i]>max){
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
