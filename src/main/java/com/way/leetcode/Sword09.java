package com.way.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wayleung
 * @description
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-11-13 09:13:47
 */
public class Sword09 {


}


class CQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if(outStack.isEmpty()){
            if(inStack.isEmpty()){
                return -1;
            }else{
                while(!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                return outStack.pop();
            }
        }else{
            return outStack.pop();
        }
    }
}




//class CQueue {
//
//    List<Integer> list;
//
//    public CQueue() {
//        list = new ArrayList<>();
//    }
//
//    public void appendTail(int value) {
//        list.add(value);
//    }
//
//    public int deleteHead() {
//        if(list!=null&&list.size()>0){
//            int result = list.get(0);
//            list.remove(0);
//            return result;
//        }else{
//            return -1;
//        }
//    }
//}
//
//


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
