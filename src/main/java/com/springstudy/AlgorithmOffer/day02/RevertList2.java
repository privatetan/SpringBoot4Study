package com.springstudy.AlgorithmOffer.day02;

/**
 * 反转单链表
 *
 * 描述：
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 例子
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class RevertList2 {
    /**
     * 使用递归
     */
    public  ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur = reverseList(head.next); //这里将一直调用，直到 head.next == null
        head.next.next = head; //将head.next.next指针指向 head
        head.next = null; //将head.next 指针指向 null
        return cur; //返回
    }

    /**
     * 使用迭代
     */
    public  ListNode reverseList2(ListNode head) {
       ListNode pre = null; //反转后的链表
       ListNode cur = head; //被反转链表，用作迭代
       while(cur.next!=null){
           //临时将被反转的节点的下一个节点记录起来
           ListNode temp = head.next;
           //将被反转的节点的next指针指向反转后的链表
           head.next = pre;
           //将反转后的链表节点指针指向head，往后移动
           pre = head;
           //将被反转的链表节点指针指向temp，往后移动
           head = temp;
       }
       return pre;
    }
}
