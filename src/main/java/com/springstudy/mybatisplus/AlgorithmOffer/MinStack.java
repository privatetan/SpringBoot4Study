package com.springstudy.mybatisplus.AlgorithmOffer;

import java.util.LinkedList;

/**
 * 包含main函数的栈
 *
 * 描述：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 思路：
 * 使用辅助栈，存放最小值
 *
 * 栈：使用LinkedList代替stack
 *
 *
 */
public class MinStack {
    //定义两个栈，一个主栈，一个记录最小元素栈
    LinkedList<Integer> mainList,minList;

    public MinStack() {
       //初始化两个栈
        mainList = new LinkedList<>();
        minList = new LinkedList<>();
        minList.push(Integer.MAX_VALUE);
    }

    /**
     * 存值
     * @param x x
     */
    public void push(int x) {
        mainList.push(x);
        //存放最小值
        minList.push(minList.peek()<=x?minList.peek():x);
    }

    /**
     * 删值(移除栈顶值)
     */
    public void pop() {
      mainList.pop();
      minList.pop();
    }

    /**
     * 获取栈顶值
     * @return int
     */
    public int top() {
      return mainList.peek();
    }

    /**
     * 获取最小元素
     * @return int
     */
    public int min() {
     return minList.peek();
    }
}
