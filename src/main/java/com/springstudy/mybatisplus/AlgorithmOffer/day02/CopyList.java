package com.springstudy.mybatisplus.AlgorithmOffer.day02;

import java.util.HashMap;

/**
 * 复杂链表的复制
 *
 * 描述：
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 例子：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 */
public class CopyList {
    /**
     * 方法1：使用回溯 + 哈希表（map）
     * 使用hashmap 存放新旧链表的next、random指针；
     */
    HashMap<Node,Node> hashMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        //如果存在映射，直接返回
        if(hashMap.containsKey(head)){
            return hashMap.get(head);
        }
        //创建临时节点
        Node tempNode = new Node(head.val);
        //保存映射关系
        hashMap.put(head,tempNode);
        //获取next指针映射关系
        tempNode.next = copyRandomList(head.next);
        //获取random指针映射关系
        tempNode.random = copyRandomList(head.random);
        return  tempNode;
    }
}

/**
 * 节点定义
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}