package com.way.test;


/**
 * @author wayleung
 * @description
 * @date 2020-08-19 11:35:56
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {2,3,8,8,8,6,9,10,-1,0};
//        new Sort().insertSort(a);
        new Sort().bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }


    public int[] insertSort(int[] array) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(" start:"+start+" end:"+end+" use:"+(start - end));
        return array;
    }

    public int[] bubbleSort(int[] array) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(" start:"+start+" end:"+end+" use:"+(start - end));
        return array;
    }

    public int[] selectSort(int[] array) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(" start:"+start+" end:"+end+" use:"+(start - end));
        return array;
    }
}
