package com.way.leetcode;

import com.sun.source.tree.ReturnTree;

/**
 * @author wayleung
 * @description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-11-12 19:41:23
 */
public class Sword06 {

    public static void main(String[] args) {
    }

    public int[] reversePrint(ListNode head) {
        int size = getListNodeSize(head);
        int[] result = new int[size];
        for (int i = 0; i < result.length&&head!=null; i++) {
            result[result.length-1-i] = head.val;
            head = head.next;
        }
        return result;
    }

     int getListNodeSize(ListNode head){
        if(head==null){
            return 0;
        }else{
            int result = 1;
            while(head.next!=null){
                head = head.next;
                result++;
            }

            return result;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
