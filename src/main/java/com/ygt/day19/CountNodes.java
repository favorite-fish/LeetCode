package com.ygt.day19;

import com.ygt.day16.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * https://leetcode.cn/problems/count-complete-tree-nodes/description/
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 示例：
 * [1,2,3,4,5,6]
 *                   1
 *                  / \
 *                 2   3
 *                / \  /
 *               4  5 6
 * 输出结果为：6
 * @author ygt
 * @since 2024/8/31
 */
public class CountNodes {
    public static void main(String[] args) {
       /*
                      1
                     / \
                    2   3
                   / \  /
                  4  5 6
        */
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode root = new TreeNode(1, node2, node3);

        System.out.println(new CountNodes().countNodes(root));
    }

    /**
     * 递归后序遍历完全二叉树的节点个数
     * 根据左右根方式，先左右子树得到深度，最后相加总和并加一（当前结点）。
     *                     1
     *                    / \
     *                   2   3
     *                  / \  /
     *                 4  5 6
     *  得到的为：3
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回结点个数
     */
    public int countNodes(TreeNode root) {
        // 1.明确的知道递归的终止条件
        // 如果结点为空，就返回0，表示结点数为0。
        if(root == null) {
            return 0;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 根据后序遍历，左右根，先求它的左子树的结点数量，再求右子树的结点数量，最后相加总和并加一（当前结点）。
        // 为什么需要加1，因为需要加上当前中间结点，所以得到就是目前结点为根结点的树的结点个数
        // 求左子树的个数
        int leftCount = countNodes(root.left);
        // 求右子树的个数
        int rightCount = countNodes(root.right);
        // 返回左右子树的个数相加并+1
        return leftCount + rightCount + 1;
    }
}