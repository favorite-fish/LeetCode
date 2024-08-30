package com.ygt.day18;


import com.ygt.day16.TreeNode;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/description/
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例：
 * [4,2,7,1,3,6,9]
 *                   4
 *                  /  \
 *                 /    \
 *                2      7
 *               / \    / \
 *              1   2  6   9
 * 输出结果为[4,7,2,9,6,3,1]
 *                   4
 *                  /  \
 *                 /    \
 *                7      2
 *               / \    / \
 *              9   6  2   1
 * @author ygt
 * @since 2024/8/30
 */
public class InvertTree {

    public static void main(String[] args) {
       /*
                   4
                  /  \
                 /    \
                2      7
               / \    / \
              1   2  6   9
        */
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(7, node6, node7);
        TreeNode root = new TreeNode(4, node2, node3);

        new InvertTree().invertTree(root);
    }

    /**
     * 迭代层序遍历翻转二叉树:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层将结点的左右孩子都翻转。
     *                    1               1
     *                   / \     ==>     / \
     *                  2   3           3   2
     *  得到的为：[1,3,2]
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回根结点
     */
    public TreeNode invertTree(TreeNode root) {
        // 需要先判空
        if(root == null) {
            return null;
        }

        // 创建队列来存储结点
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 先存入根结点
        queue.offer(root);

        // 判断队列是否有值，有值就逐个出队列并翻转结点
        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                TreeNode poll = queue.poll();

                // 翻转当前结点的左右孩子
                TreeNode left = poll.left;
                poll.left = poll.right;
                poll.right = left;

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
        return root;
    }
}