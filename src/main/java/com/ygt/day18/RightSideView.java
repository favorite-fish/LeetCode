package com.ygt.day18;

import com.ygt.day16.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例：
 * [1,2,3,null,5,null,4]
 *                   1
 *                  / \
 *                 2   3
 *                  \   \
 *                   5   4
 * 输出结果为：[1,3,4]
 * @author ygt
 * @since 2024/8/30
 */
public class RightSideView {
    public static void main(String[] args) {
       /*
                    1
                   / \
                  2   3
                   \   \
                    5   4
        */
        TreeNode node7 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node3 = new TreeNode(3, null, node7);
        TreeNode root = new TreeNode(1, node2, node3);

        System.out.println(new RightSideView().rightSideView(root));
    }

    /**
     * 迭代层序遍历二叉树的右视图:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层查询，得到的最后一个结点，就是右视图形状。
     *                    1
     *                   / \
     *                  2   3
     *                       \
     *                        4
     *  得到的为：【1,3,4】
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  右视图的结果集合【1,3,4】
     */
    public List<Integer> rightSideView(TreeNode root) {
        // 存储右视图返回集合
        List<Integer> result = new ArrayList<>();

        // 需要先判空
        if(root == null) {
            return result;
        }
        // 创建队列来存储结点
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 先存入根结点
        queue.offer(root);

        // 判断队列是否有值，有值就逐个出队列并在一个层次深度加一
        while (!queue.isEmpty()) {
            int size = queue.size();
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

                // 如果是最后一个结点，代表循环体减下来的size 为0
                if(size == 0) {
                    // 存储每层的最后一个结点
                    result.add(poll.val);
                }
            }
        }
        return result;
    }
}