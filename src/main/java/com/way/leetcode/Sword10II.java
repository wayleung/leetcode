package com.way.leetcode;

/**
 * @author wayleung
 * @description
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-11-16 10:37:44
 */
public class Sword10II {

    /**
     * 从f(7)得出 f（5）离f(7) 只有一次跳两阶级 或者 f（6） 离f(7) 只有一次跳两阶级得出
     * f(n) = f(n-1)+f(n-2)
     * 不能直接递归 会超时
     * @param
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new Sword10II().numWays(2));
    }

    public int numWays(int n) {
        if(n==0){
            return 1;
        }else if(n==1){
            return 1;
        }else{
        int sum = 0;
        int n1 = 1;
        int n2 = 1;
        while(n>=2){
            sum = n1+n2;
            sum = sum%1000000007;
            n1 = n2;
            n2 = sum;
            n--;
        }
        return sum;
        }
    }
}
