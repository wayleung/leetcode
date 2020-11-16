package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-20 08:55:16
 *
 *
 * 最优解
 * class Solution {
 *     public String reverseLeftWords(String s, int n) {
 *         return s.substring(n) + s.substring(0,n);
 *     }
 * }
 *
 */
public class SwordOffer58 {

    public static void main(String[] args) {
        System.out.println(new SwordOffer58().reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            temp[i] = chars[i];
        }
        int index = 0;
        for (int j = 0; j < chars.length; j++) {
            if (j >= chars.length - n) {
                chars[j] = temp[index++];
            } else {
                chars[j] = chars[j+n];
            }
        }
        return new String(chars);
    }
}
