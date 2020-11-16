package com.way.leetcode;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-01-02
 */
public class Test14 {
    public static void main(String[] args) {
        System.out.println(new Test14().longestCommonPrefix(new String[]{"sss","ss11","ss2223"}));;
    }

    public String longestCommonPrefix(String[] strs) {
        int minLength = strs[0].length();
        for (int i=0;i<strs.length;i++){
            if (strs[i].length()<minLength){
                minLength = strs[i].length();
            }
        }

        if(minLength<=0){
            return "";
        }else{
            String returnStr ="";
            for (int i=0;i<strs.length-1;i++){
                for (int j=0;j<minLength;j++){
                    char former = strs[i].charAt(j);
                    char latter = strs[i + 1].charAt(j);
                    if(former==latter){
                        returnStr=returnStr+strs[i].charAt(j);
                    }else {
                        break;
                    }
                }
            }
            return returnStr;
        }
    }
}
