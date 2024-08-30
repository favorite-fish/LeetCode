package com.ygt.day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * [1,2,3,4,5,6,7]
 *                   1
 *                  /  \
 *                 /    \
 *                2      3
 *               / \    / \
 *              4   5  6   7
 * 得到的前序遍历的结果为：1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7
 * 输出结构为[[1], [2, 3], [4, 5, 6, 7]]
 * @author ygt
 * @since 2024/8/29
 */
public class LevelOrder {
    public static void main(String[] args) {
         /*
                  1
                 /  \
                /    \
               2      3
              / \    / \
             4   5  6   7
        */
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode root = new TreeNode(1, node2, node3);

        List<List<Integer>> resultList = new LevelOrder().levelOrder(root);
        List<List<Integer>> resultList2 = new LevelOrder().levelOrder2(root);
        System.out.println(resultList);
        System.out.println(resultList2);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 递归层序遍历 ==> 从根节点，0层开始
        levelOrder(root, 0, result);
        return result;
    }

    /**
     * 递归层序遍历:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路先把左孩子那一路的每一层全部处理完，再去处理右孩子的每一层。
     *                    1
     *                   / \
     *                  2   3
     *  得到的为：1 --> 2 --> 3
     * @param root 一开始进入的是根节点，从根节点开始遍历
     * @param deep 层次深度，每次递归进去，代表层次深度加一
     * @param result 层次集合，存储层次对应的结点 如上述会得到的结果为：[[1], [2, 3]] ==> 第一层为[1]，第二层为[2,3]
     */
    public void levelOrder(TreeNode root, Integer deep, List<List<Integer>> result) {
        // 1. 明确的知道递归的终止条件
        // 如果结点为空，就不需要进行任何操作，代表根节点为空或者是结点无子树。
        if(root == null) {
            return;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 2.1 层次深度 +1表示进了新的一层；
        // 2.2 利用层次深度，来判断是否需要创建对应存储层次的集合，[[]]， 外层代表着层次，内层代表层次需要存储的结点。
        // 2.3 在每层中，通过当前层次深度来存储对应层次集合，加入本结点的值；
        // 2.4 并不断让当前结点的左右孩子不断递归下去

        // 2.1 层次深度 +1表示进了新的一层；
        deep++;

        // 2.2 利用层次深度，来判断是否需要创建对应存储层次的集合
        // 当层级增加时，list的size也要增加，利用list的size进行层级界定
        if (result.size() < deep) {
            result.add(new ArrayList<>());
        }

        // 2.3 在每层中，通过当前层次深度来存储对应层次集合，加入本结点的值；
        // list集合是索引0处开始的，所以需要减一
        result.get(deep - 1).add(root.val);

        // 2.4 并不断让当前结点的左右孩子不断递归下去
        // 递归深入访问左子树
        levelOrder(root.left, deep, result);

        // 递归深入访问右子树
        levelOrder(root.right, deep, result);
    }

    /**
     * 迭代层序遍历:
     * 按照二叉树中的层次从左到右依次遍历每层中的结点，
     * 主要思路先把左孩子那一路的每一层全部处理完，再去处理右孩子的每一层。
     *                    1
     *                   / \
     *                  2   3
     *  上述会得到的结果为：[[1], [2, 3]] ==> 第一层为[1]，第二层为[2,3]
     * @param root 一开始进入的是根节点，从根节点开始遍历
     * @return  存储层次对应的结点 如上述会得到的结果为：[[1], [2, 3]] ==> 第一层为[1]，第二层为[2,3]
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        // 存储返回的层级结点
        List<List<Integer>> result = new ArrayList<>();

        // 创建队列来存储结点
        LinkedList<TreeNode> queue = new LinkedList<>();

        // 需要先判空
        if(root == null) {
            return result;
        }

        // 先存入根结点
        queue.offer(root);

        // 判断队列是否有值，有值就逐个出队列并查找左右结点
        while(!queue.isEmpty()) {

            // 记录每层需要出队列的次数
            int size = queue.size();
            // 当前层数的结点集合
            List<Integer> list = new ArrayList<>();

            // 循环次数大小，出队列。
            while (size > 0) {
                // 出队列，得到当前结点
                TreeNode curNode = queue.poll();

                // 并存储在当前层数结点集合
                list.add(curNode.val);

                // 查找左右结点
                if(curNode.left != null) {
                    // 入队列
                    queue.offer(curNode.left);
                }
                if(curNode.right != null) {
                    // 入队列
                    queue.offer(curNode.right);
                }
                // 还得减少次数，避免额外出一些不必要的结点，或者为空
                size--;
            }

            // 这里出来，代表一层的循环结束，添加层级集合中。
            result.add(list);
        }
        return result;
    }
}