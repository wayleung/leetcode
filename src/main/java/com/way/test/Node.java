package com.way.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author wayleung
 * @description
 * @date 2020-08-10 16:38:06
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    Node next;
    Integer data;

    @Override
    public String toString() {
        if(next!=null){
            return data+"->"+next;
        }else{
            return data+"";
        }
    }

    public boolean hasNext(){
        if(next==null){
            return false;
        }else{
            return true;
        }
    }

//    public void add(Node newNode){
//        if(!hasNext()){
//            this.next = newNode;
//        }else{
//            //先保存当前节点的下一个节点
//            Node temp  = this.next;
//            //再把新节点的最后一个节点指向原来下一个节点
//            newNode.getTail().next = temp;
//            //最后把当前节点的下一个节点指向新节点
//            this.next = newNode;
//        }
//    }
//
//    public Node getTail(){
//        Node index = this;
//        if(index.next!=null){
//            return index.next.getTail();
//        }else{
//            return this;
//        }
//    }
}
