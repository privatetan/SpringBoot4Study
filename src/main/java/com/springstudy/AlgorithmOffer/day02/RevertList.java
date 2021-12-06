package com.springstudy.AlgorithmOffer.day02;

import java.util.LinkedList;

/**
 * 从尾到头打印链表
 *
 * 描述
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 例子
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 */
public class RevertList {
    /**
     * 解决1：使用栈的特性 先进后出
     * @param head head
     * @return int[]
     */
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while(head!=null){
            list.push(head.val);
            head = head.next;
        }
        int[] reverts = new int[list.size()];
        for (int i = 0; i<reverts.length; i++){
            reverts[i] = list.pop();
        }
        return reverts;
    }


    /**
     * 解决2：获取元素个数，创建数组，反向遍历数组添加元素
     */
    public int[] reversePrint2(ListNode head) {
        ListNode p = head;  //注意使用新的Node，原Node会被清空
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        int[] reverts = new int[length];
        for (int i = length-1; i>=0; i--){
            reverts[i] = p.val;
            p = p.next; //注意要移动指针
        }
        return reverts;
    }
}

/**
 * node
 */
class  ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}