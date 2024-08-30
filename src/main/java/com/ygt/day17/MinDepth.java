package com.ygt.day17;

import com.ygt.day16.TreeNode;

import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例：
 * [3,9,20,null,null,15,7]
 *                   3
 *                  / \
 *                 /   \
 *                9    20
 *                     / \
 *                    15  7
 * 输出结果为：2
 * @author ygt
 * @since 2024/8/29
 */
public class MinDepth {
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

        int depth = new MinDepth().minDepth(root);
        int depth2 = new MinDepth().minDepth2(root);
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
     * @return  返回最小深度
     */
    public int minDepth(TreeNode root) {
        // 1.明确的知道递归的终止条件
        // 如果结点为空，就返回0，表示高度为0。
        if (root == null) {
            return 0;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 根据后序遍历，左右根，先求它的左子树的深度，再求右子树的深度，最后取最小深度时，需要判断是否为叶子结点：
        // 求左子树的深度
        int leftDepth = minDepth(root.left);
        // 求右子树的深度
        int rightDepth = minDepth(root.right);

        // 1. 如果左子树为空，右子树不为空，说明最小深度是右子树的深度 + 1；
        if (root.left == null) {
            return rightDepth + 1;
        }

        // 2. 如果右子树为空，左子树不为空，最小深度是左子树的深度 + 1；
        if (root.right == null) {
            return leftDepth + 1;
        }

        // 3. 如果左右子树都不为空，返回左右子树深度最小值 + 1 。
        return Integer.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代层序遍历二叉树的最大深度:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层增加二叉树的深度，并在每层中只要找到一个叶子结点就可以返回最小深度了。
     *                    1
     *                   / \
     *                  2   3
     *                       \
     *                        4
     *  得到的为：3
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回最小深度
     */
    public int minDepth2(TreeNode root) {
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
                // 只要是当前结点是叶子结点，代表找到最小深度了。
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
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