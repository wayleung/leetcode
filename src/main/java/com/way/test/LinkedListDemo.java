package com.way.test;

/**
 * @author wayleung
 * @description
 * @date 2020-08-10 16:37:56
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        Node node = new Node(new Node(new Node(new Node(new Node(null, 1), 2), 3), 4), 5);
        System.out.println(node.toString());

        System.out.println(getTail(node));
        Node index = node;
        while (index.hasNext()) {
            if (index.data == 2) {
                add(node, new Node(new Node(new Node(null, 888), 999), 666));
            }
            index = index.next;
        }


        System.out.println(node.toString());

        System.out.println(remove(node, 888));
    }


    public static void add(Node thisNode, Node newNode) {
        if (!thisNode.hasNext()) {
            thisNode.next = newNode;
        } else {
            //先保存当前节点的下一个节点
            Node temp = thisNode.next;
            //再把新节点的最后一个节点指向原来下一个节点
            getTail(newNode).next = temp;
            //最后把当前节点的下一个节点指向新节点
            thisNode.next = newNode;
        }
    }

    public static Node remove(Node thisNode, Integer data) {
        Node index = thisNode;

        do {
            if (index.data.equals(data)) {
                return index;
            }
            index = index.next;
        } while (index.hasNext());
        return null;
    }

    public static Node getTail(Node thisNode) {
        Node index = thisNode;
        if (index.next != null) {
            return getTail(index.next);
        } else {
            return thisNode;
        }
    }
}
