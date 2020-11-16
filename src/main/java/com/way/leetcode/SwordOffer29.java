package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-09-02 09:50:31
 */
public class SwordOffer29 {
    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int[] result = new int[matrix.length * matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                int j = 0;
                if(i<matrix.length){
                    result[i] = matrix[j][i];
                }else if(i<(matrix.length+matrix[0].length-1)){
                    result[i] = matrix[++j][matrix[0].length];
                }
            }
            return result;
        }else{
            return new int[]{};
        }
    }


    public void setOutSide(int[] result,int[][] matrix,int index){
        for (int i = 0; i < matrix.length; i++) {

        }
    }
}
