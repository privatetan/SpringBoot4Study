package com.springstudy.AlgorithmOffer.day01;

import java.util.LinkedList;

/**
 * 用两个栈实现队列
 *
 * 描述：
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 例子：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 *
 * 题目解析：
 * 1.创建队列，返回值为null
 * 2.将3压入栈，返回值为null
 * 3.将栈底的元素删除，也就是消息队列中先进来的元素，所以是deleteHead，返回该元素的数值，所以为3
 * 4.继续删除栈底的元素，但是没有元素了，所以返回-1。
 *
 * 有没有发现先进来的数字，首先显示出来了，但是题目中说要使用栈，
 * 栈是先进后出的，使用栈来实现先进先出，
 * 在这里使用两个栈就好了，从一个进来再到另一个栈，这样顺序就是先进先出了。
 * 题目的主旨写在第一句，就是，使用两个栈实现一个队列。
 *
 * 栈：使用LinkedList代替Stack
 * 队列：使用LinkedList
 */
public class CQueue {
    //创建2个链表(栈)
    LinkedList<Integer> listOne,listTwo;

    public CQueue() {
        listOne = new LinkedList<>();
        listTwo = new LinkedList<>();
    }

    public void appendTail(int value) {
       listOne.push(value);
    }

    public int deleteHead() {
        //首先判断如果第二个栈是否为空
        if(listTwo.isEmpty()){
         //如果第一个栈不为空，则将第一个栈里面的元素全部迁移过来
          while(!listOne.isEmpty()) {
              listTwo.push(listOne.pop());
          }
        }
        //再次判断第二个栈是否为空
        if(listTwo.isEmpty()){
            return -1;
        }
        //取出第二个栈的元素
        return listTwo.pop();
    }
}
