package com.springstudy.mybatisplus.AlgorithmOffer.day06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印二叉树 III
 * <p>
 * 描述：
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即：第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印；
 * 其他行以此类推。
 * <p>
 * 例子：
 * 给定二叉树:[3,9,20,null,null,15,7],
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
 * [20,9],
 * [15,7]
 * ]
 */
public class BFSForTreeThree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        List<List<Integer>> results = new ArrayList<>();
        while (!nodes.isEmpty()) {
            LinkedList<Integer> temps = new LinkedList<>();
            for (int i = nodes.size(); i > 0; i--) {  //注意这一步
                TreeNode node = nodes.poll();
                if (results.size() % 2 == 1) {
                    temps.addFirst(node.val);
                } else {
                    temps.addLast(node.val);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            results.add(temps);
        }

        return results;
    }
}
