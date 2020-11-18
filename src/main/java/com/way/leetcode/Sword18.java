package com.way.leetcode;

/**
 * @author wayleung
 * @description 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-11-18 14:04:39
 *
 *
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 37.7 MB
 * , 在所有 Java 提交中击败了
 * 95.08%
 * 的用户
 * 炫耀一下:
 */
public class Sword18 {

    public static void main(String[] args) {
        new Sword18().test();
    }


    public void test() {
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node1 = new ListNode(1);
        ListNode node9 = new ListNode(9);
        node4.next = node5;
        node5.next = node1;
        node1.next = node9;
        System.out.println(new Sword18().deleteNode(node4, 5));
    }




    public ListNode deleteNode(ListNode head, int val) {
        //处理头节点的两种特殊情况
        //1.头节点为空
        if(head==null){
            return null;
        }
        //2.头节点就是要删除的节点
        if(head.val==val){
            return head.next;
        }
        //当前位置的ListNode引用
        ListNode now;
        //上一个位置的ListNode引用
        ListNode pre;
        now = head.next;
        pre = head;
        while(now!=null){
            if(now.val==val){
                //删除
                pre.next = now.next;
            }
            //两个引用移动到下一个位置
            now = now.next;
            pre = pre.next;
        }
        return head;
    }



    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
