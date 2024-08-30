package com.ygt.day17;

import com.ygt.day16.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数
 * 示例：
 * [3,9,20,null,null,15,7]
 *                   3
 *                  / \
 *                 /   \
 *                9    20
 *                     / \
 *                    15  7
 * 输出结果为：3
 * @author ygt
 * @since 2024/8/29
 */
public class MaxDepth {
    public static void main(String[] args) {
       /*
                 3
                / \
               /   \
              9     20
                    / \
                   15  7
        */
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20, node6, node7);
        TreeNode root = new TreeNode(3, node2, node3);

        int depth = new MaxDepth().maxDepth(root);
        int depth2 = new MaxDepth().maxDepth2(root);
        System.out.println(depth);
        System.out.println(depth2);
    }


    /**
     * 递归后序遍历二叉树的最大深度
     * 根据左右根方式，先左右子树得到深度，最后得出当前结点的最大深度为多少。
     *                    1
     *                   / \
     *                  2   3
     *                       \
     *                        4
     *  得到的为：3
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回最大深度
     */
    public int maxDepth(TreeNode root) {
        // 1.明确的知道递归的终止条件
        // 如果结点为空，就返回0，表示高度为0。
        if(root == null) {
            return 0;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 根据后序遍历，左右根，先求它的左子树的深度，再求右子树的深度，最后取左右深度最大的数值再+1
        // 为什么需要加1，因为需要加上当前中间结点，所以得到就是目前结点为根结点的树的深度。
        // 求左子树的深度
        int leftDepth = maxDepth(root.left);
        // 求右子树的深度
        int rightDepth = maxDepth(root.right);
        // 返回左右子树的最大深度+1
        return Integer.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代层序遍历二叉树的最大深度:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层增加二叉树的深度。
     *                    1
     *                   / \
     *                  2   3
     *                       \
     *                        4
     *  得到的为：3
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回最大深度
     */
    public int maxDepth2(TreeNode root) {
        // 需要先判空
        if(root == null) {
            return 0;
        }
        // 创建队列来存储结点
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 先存入根结点
        queue.offer(root);

        // 当前深度。
        int depth = 0;

        // 判断队列是否有值，有值就逐个出队列并在一个层次深度加一
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 当前深度加一。
            depth++;
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
            }
        }
        return depth;
    }
}