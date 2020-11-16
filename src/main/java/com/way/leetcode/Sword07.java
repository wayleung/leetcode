package com.way.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wayleung
 * @description 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [ 3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 */
public class Sword07 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */


    /**
     * 递归 画图理解
     * @param preorder
     * @param inorder
     * @return
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recycleTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }


    public TreeNode recycleTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        //结束条件
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        //递归
        for (int i=inStart;i<=inEnd;i++){
            if(inorder[i] ==preorder[preStart] ){
                root.left = recycleTree(preorder,preStart+1,preStart+i-inStart,inorder,inStart,i-1);
                root.right = recycleTree(preorder,preStart+i-inStart+1,preEnd,inorder,i+1,inEnd);
                break;
            }
        }

        return root;
    }



    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
              val = x;
          }
    }
}
