package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-11-12 14:00:38
 */
public class Sword05 {


    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
    public static String replaceSpace(String s) {
//        return s.replaceAll(" ","%20");


        int size = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                size = size+2;
            }
        }
        char[] newChars = new char[size];
        int index = 0;
        for (int i = 0; i < chars.length;i++) {
            if(chars[i]==' '){
                newChars[i+index*2] = '%';
                newChars[i+index*2+1] = '2';
                newChars[i+index*2+2] = '0';
                index++;
            }else{
                newChars[i+index*2] = chars[i];
            }
        }
        return new String(newChars);
    }
}
