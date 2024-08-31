package com.ygt.day19;

import com.ygt.day16.TreeNode;

/**
 * 110.平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 * 给定一个二叉树，判断它是否是平衡二叉树
 * 示例：
 * 输入：root = [3,9,20,null,null,15,7]
 *                   3
 *                  / \
 *                 9   20
 *                    / \
 *                   15   7
 * 输出：true
 * @author ygt
 * @since 2024/3/12
 */
public class IsBalanced {

    public static void main(String[] args) {
       /*
                 3
                /  \
               /    \
              9      20
                     / \
                    15   7
        */
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20, node6, node7);
        TreeNode root = new TreeNode(3, node2, node3);

        System.out.println(new IsBalanced().isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >=0;
    }

    /**
     * 递归后序遍历:
     * 先左子树、然后是右子树、最后是根结点
     * 求左右子树的高度，比较左右子树的高度是否相差过大
     *                    1
     *                   / \
     *                  2   3
     *  得到的为：2
     * @param root 一开始进入的是根节点，从根节点开始遍历
     */
    private int getHeight(TreeNode root) {
        // 1. 明确的知道递归的终止条件
        // 如果结点为空，就不需要进行任何操作，代表结点的高度为0
        if(root == null) {
            return 0;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 分别求出其左右子树的高度，然后如果差值小于等于1，则返回当前二叉树的高度，否则返回-1，表示已经不是二叉平衡树了。

        // 获取左子树的高度
        int leftHeight = getHeight(root.left);
        // 如果左子树的高度是 - 1，可以直接返回了
        if(leftHeight == -1) {
            return -1;
        }

        // 获取右子树的高度
        int rightHeight = getHeight(root.right);
        // 如果右子树的高度是 - 1，可以直接返回了
        if(rightHeight == -1) {
            return -1;
        }

        // 比较左右子树的绝对值高度(绝对值，没办法判断左子树一定比右子树高，可能矮，所以用绝对值)
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 返回树的高度即可
        return Integer.max(leftHeight, rightHeight) + 1;
    }
}