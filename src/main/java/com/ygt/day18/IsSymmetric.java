package com.ygt.day18;


import com.ygt.day16.TreeNode;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例：
 * [1,2,2,3,4,4,3]
 *                   1
 *                  /  \
 *                 /    \
 *                2      2
 *               / \    / \
 *              3   4  4   3
 * 输出结果为：true
 * @author ygt
 * @since 2024/8/30
 */
public class IsSymmetric {
    public static void main(String[] args) {
        /*
                 1
                /  \
               /    \
              2      2
             / \    / \
            3   4  4   3
        */
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(2, node6, node7);
        TreeNode root = new TreeNode(1, node2, node3);

        boolean symmetric = new IsSymmetric().isSymmetric(root);
        System.out.println(symmetric);
    }

     /**
     * 迭代层序遍历对称二叉树:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层将结点的左右孩子是否对称
     *                    1
     *                   / \
     *                  2   2
     *  得到的为：true
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回根结点
     */
    public boolean isSymmetric(TreeNode root) {
        // 创建队列来存储结点
        LinkedList<TreeNode> queue = new LinkedList<>();

        // 存储根结点的左右孩子结点
        queue.offer(root.left);
        queue.offer(root.right);

        // 判断队列是否有值，有值就同时出队列2个结点并判断是否对称
        while(!queue.isEmpty()) {
            // 出队列，得到左右孩子结点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // 如果是左右为空，代表为对称
            if(left == null && right == null) {
                continue;
            }

            // 只要有一个满足以下条件，不对称，就直接返回false即可
            if(left == null || right == null || left.val != right.val) {
                return false;
            }

            // 比较二叉树左右子树的外侧是否对称：存入的顺序的是左结点的左孩子结点，右结点的右孩子结点；
            queue.offer(left.left);
            queue.offer(right.right);

            // 比较二叉树左右子树的内侧是否对称：存入的顺序的是左结点的右孩子结点，右结点的左孩子结点；
            queue.offer(right.left);
            queue.offer(left.right);
        }
        return true;
    }
}