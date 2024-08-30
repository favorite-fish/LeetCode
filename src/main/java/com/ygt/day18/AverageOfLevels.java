package com.ygt.day18;


import com.ygt.day16.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * 示例：
 * [3,9,20,null,null,15,7]
 *                   3
 *                  / \
 *                 /   \
 *                9    20
 *                     / \
 *                    15  7
 * 输出结果为：[3.00000,14.50000,11.00000]
 * @author ygt
 * @since 2024/8/30
 */
public class AverageOfLevels {
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

        System.out.println(new AverageOfLevels().averageOfLevels(root));
    }

    /**
     * 迭代层序遍历二叉树的层平均值:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路逐层查询，每层中求个总和，最后取一个平均值。
     *                    1
     *                   / \
     *                  2   3
     *                       \
     *                        4
     *  得到的为：【1,3,4】
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  右视图的结果集合【1,3,4】
     */
    public List<Double> averageOfLevels(TreeNode root) {
        // 存储层平均值返回集合
        List<Double> result = new ArrayList<>();

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
            // 记录当前层数结点值总和
            double sum = 0d;
            // 记录当前层数结点个数大小。
            int sizeFlag = size;
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
                sum+=poll.val;
            }
            // 最后两者相除
            result.add(sum/sizeFlag);
        }
        return result;
    }
}