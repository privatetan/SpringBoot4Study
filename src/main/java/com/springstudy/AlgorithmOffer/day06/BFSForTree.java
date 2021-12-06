package com.springstudy.AlgorithmOffer.day06;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下打印二叉树 （直接看题解）
 *
 * 描述：
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例子：
 * 给定二叉树：[3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * 返回：
 * [3,9,20,15,7]
 *
 * 技巧：
 * 1、二叉树从上往下遍历，使用BFS（广度搜索算法，层序遍历）
 * 2、使用链表存储节点
 * 3、使用数组来存储节点值
 */
public class BFSForTree {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //使用链表来存储节点
        LinkedList<TreeNode> nodes = new LinkedList<>();
        //将根节点先存入链表
        nodes.add(root);
        //使用集合保存节点值
        //为什么不直接使用数组，因为数组需要初始长度，集合可以自动扩容
        ArrayList<Integer> values = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll(); //删除并返回第一个元素。
            values.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        //将集合转化为数组
        int[] res = new int[values.size()];
        for (int i = 0; i < values.size(); i++)
            res[i] = values.get(i);
        return res;
    }
}
