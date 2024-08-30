package com.ygt.day18;


import com.ygt.day16.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * 示例：
 * [1,3,2,5,3,null,9]
 *                   1
 *                  / \
 *                 3   2
 *                / \   \
 *               5   3   9
 * 输出结果为：[1,3,9]
 * @author ygt
 * @since 2024/8/30
 */
public class LargestValues {
    public static void main(String[] args) {
       /*
                      1
                     / \
                    3   2
                   / \   \
                  5   3   9
        */
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        TreeNode node2 = new TreeNode(3, node4, node5);
        TreeNode node3 = new TreeNode(2, null, node7);
        TreeNode root = new TreeNode(1, node2, node3);

        System.out.println(new LargestValues().largestValues(root));
    }

    /**
     * 迭代层序遍历查找在每个树行中找最大值
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层查询，并在每层中得到最大的结点，就存储到集合。
     *                   1
     *                  / \
     *                 3   2
     *                / \   \
     *               5   3   9
     *  得到的为：【1,3,9】
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  层最大值的结果集合【1,3,9】
     */
    public List<Integer> largestValues(TreeNode root) {
        // 存储层最大值返回集合
        List<Integer> result = new ArrayList<>();

        // 需要先判空
        if(root == null) {
            return result;
        }
        // 创建队列来存储结点
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 先存入根结点
        queue.offer(root);

        // 判断队列是否有值
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 记录最大值的结点值
            Integer max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                // 判断是否还有左右孩子结点
                if(poll.left != null) {
                    // 入队列
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    // 入队列
                    queue.offer(poll.right);
                }
                max = Integer.max(max, poll.val);
            }
            // 最后存储最大值
            result.add(max);
        }
        return result;
    }
}