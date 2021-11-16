package com.springstudy.mybatisplus.AlgorithmOffer.day06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印二叉树 II
 * <p>
 * 描述：
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例子：
 * 给定二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BFSForTreeTwo {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //定义链表存放节点
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        //定义数组存放结果值
        List<List<Integer>> res = new ArrayList();
        while (!nodes.isEmpty()) {
            List<Integer> temps = new ArrayList();
            for (int i = nodes.size(); i > 0; i--) {
                TreeNode tempNode = nodes.poll();
                temps.add(tempNode.val);
                if (tempNode.left != null) {
                    nodes.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodes.add(tempNode.right);
                }
            }
            res.add(temps);
        }
        return res;
    }
}
