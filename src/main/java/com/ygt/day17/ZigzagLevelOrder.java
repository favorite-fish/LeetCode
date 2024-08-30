package com.ygt.day17;

import com.ygt.day16.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 示例：
 * [3,9,20,null,null,15,7]
 *                   3
 *                  / \
 *                 /   \
 *                9    20
 *                     / \
 *                    15  7
 * 输出结果为：[[3],[20,9],[15,7]]
 * @author ygt
 * @since 2024/8/30
 */
public class ZigzagLevelOrder {
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

        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }

    /**
     * 迭代层序遍历二叉树的锯齿形层序遍历:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层遍历，如果是双层就从右到左存储，否则从左到右
     *                    1
     *                   / \
     *                  2   3
     *                       \
     *                        4
     *  得到的为：[[1],[3,2],[4]]
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回最小深度
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 最后返回的结果集
        List<List<Integer>> result = new ArrayList<>();
        // 需要先判空
        if(root == null) {
            return result;
        }
        // 创建队列来存储结点
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 先存入根结点
        queue.offer(root);

        // 第一层从左到右，第二层从右到左，反复这样储存，以一个变量来判断
        boolean flag = false;

        // 判断队列是否有值，有值就逐个出队列
        while (!queue.isEmpty()) {
            int size = queue.size();

            flag = !flag;
            // 存储当前层的数据
            Deque<Integer> deque = new LinkedList<>();

            while (size-- > 0) {
                // 出队列，得到当前结点
                TreeNode curNode = queue.poll();

                // 并存储在当前层数结点集合
                if(flag) {
                    // 左到右
                    deque.offer(curNode.val);
                }else {
                    // 右到左
                    deque.push(curNode.val);
                }

                // 查找左右结点
                if (curNode.left != null) {
                    // 入队列
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    // 入队列
                    queue.offer(curNode.right);
                }
            }

            // 这里出来，代表一层的循环结束，添加层级集合中。
                result.add(new ArrayList<>(deque));
        }

        return result;
    }
}