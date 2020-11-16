package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * @date 2020-08-24 14:48:03
 */
public class Test459 {
    public static void main(String[] args) {
        System.out.println(new Test459().repeatedSubstringPattern("abaababaab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if(s.length()<=1){
            return false;
        }

        char firstChar = s.charAt(0);
        int repeatIndex = getRepeatIndex(s,1,firstChar);
        return ifRepeatSubString(s,repeatIndex);
    }

    private int getRepeatIndex(String s,int start, char firstChar) {
        if(start<=0||start>=s.length()){
            return -1;
        }
        for (int i = start; i < s.length(); i++) {
            if(s.charAt(i)==firstChar){
                return i;
            }
        }
        return -1;
    }

    public boolean ifRepeatSubString(String s,int repeatIndex){
        int sameLength = 0;
        for (int i = 0; i < repeatIndex; i++) {
            if(s.charAt(i)==s.charAt(repeatIndex+i)){
                sameLength++;
            }
        }
        if(sameLength==repeatIndex&&repeatIndex==s.length()/2){
            return true;
        }else{
            if(repeatIndex==s.length()/2){
                return false;
            }else{
                repeatIndex = repeatIndex*2;
                s.substring(repeatIndex);
                return ifRepeatSubString(s,repeatIndex);
            }
        }
    }
}
