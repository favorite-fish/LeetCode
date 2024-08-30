package com.ygt.day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 * 给你二叉树的根节点 root ，返回它节点值的 中序 遍历。
 * 示例：
 * [1,2,3,4,5,6,7]
 *                   1
 *                  /  \
 *                 /    \
 *                2      3
 *               / \    / \
 *              4   5  6   7
 * 得到的前序遍历的结果为：1 --> 2 --> 4 --> 5 --> 3 --> 6 --> 7
 * 输出结构为【1,2,3,4,5,6,7】
 * @author ygt
 * @since 2024/8/29
 */
public class InorderTraversal {
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

        List<Integer> resultList = new InorderTraversal().inorderTraversal(root);
        List<Integer> resultList2 = new InorderTraversal().inorderTraversal2(root);
        System.out.println(resultList);
        System.out.println(resultList2);
    }

    /**
     * 递归中序遍历:
     * 先左子树、然后是根结点、最后是右子树
     *                    1
     *                   / \
     *                  2   3
     *  得到的为：2 --> 1 --> 3
     * @param node 一开始进入的是根节点，从根节点开始遍历
     */
    // 因为题目需要返回一个集合，未避免递归过程中重复创建，提取出来即可
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1. 明确的知道递归的终止条件
        // 如果结点为空，就不需要进行任何操作，代表根节点为空或者是结点无子树。
        if(root == null) {
            return result;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 当前函数不断通过左根右的顺序，不断通过遍历结点的左子树和右子树，就可以遍历完整个二叉树。

        // 步骤： 1.递归深入访问左子树
        inorderTraversal(root.left);

        // 2. 存储当前结点的值
        result.add(root.val);

        // 3. 递归深入访问右子树
        inorderTraversal(root.right);
        return result;
    }

    /**
     * 遍历中序遍历
     *                    1
     *                   / \
     *                  2   3
     *  得到的为：2 --> 1 --> 3
     * @param root 一开始进入的是根节点，从根节点开始遍历
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // 定义栈暂存结点（表示如何从当前结点返回到上一个结点 如 2 --> 1）
        LinkedList<TreeNode> stack = new LinkedList<>();

        // 来表示上次处理过右子树的临时结点
        TreeNode right = null;

        // 从根节点开始遍历，所需要的判断的条件有
        // 1. node != null 结点不为空
        // 2. !stack.isEmpty() 栈中暂存结点不为空
        while (root != null  || !stack.isEmpty()) {
            // 如果当前结点不为空，从左子树开始
            if(root != null) {
                // 入栈
                stack.push(root);

                // 指向当前结点的左子树
                root = root.left;
            }
            else {
                // 如果当前结点为空，代表左子树已经到底了，需要返回上一个结点来遍历右子树。
                TreeNode peek = stack.peek();
                // 如果有子树为空，或者右子树已经访问过了，就可以出栈了
                // 这里的判断需要修改下，对于中序来说，右子树处不处理，都无所谓，因为要在右子树处理之前输出结点
                if (peek.right == null) {
                    // 中序遍历，就是左子树遍历完成后，要存入当前结点值
                    result.add(peek.val);
                    // 出栈，并记住访问过的右子树
                    right = stack.pop();
                }
                // 右子树处理完成了。
                else if (peek.right == right){
                    // 出栈，并记住访问过的右子树
                    right = stack.pop();
                }
                // 如果有右子树，就需要深入遍历右子树，相当于以右子树的根结点开始重新一次遍历左右子树
                else {
                    root = peek.right;
                    // 右子树待处理, 对中序来说, 要在右子树处理之前存入
                    result.add(peek.val);

                }
            }
        }
        return result;
    }
}