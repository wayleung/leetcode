package com.way.leetcode;

/**
 * @author wayleung
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021-01-15 13:44:29
 * <p>
 * f（0）=0
 * f(1)=f(1-1)+1=1
 * f(2)=f(1)+1=2
 * f(3)=f(2)+f(1)=3
 * f(4)=f(3)+f(2)+f(1)
 * f(5)=f(4)+f(3)
 * f(n)=f(n-1)+f(n-2)
 */
public class Test70 {
    public static void main(String[] args) {
        System.out.println(new Test70().climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        //不能直接递归
//        else {
//            int result = 0;
//            for (int i = n-1; i > 0; i--) {
//                result = result + climbStairs(i);
//            }
//            return result;
//        }
        int temp = 0;
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            temp = n1+n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}
