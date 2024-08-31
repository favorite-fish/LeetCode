package com.ygt.day19;

import com.ygt.day16.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例：
 * 输入：root = [5,1,4,null,null,3,6]
 *                   5
 *                  / \
 *                 1   4
 *                    / \
 *                   3   6
 * 输出：false
 * @author ygt
 * @since 2024/8/31
 */
public class IsValidBST {

    public static void main(String[] args) {
        /*
                  5
                 / \
                1   4
                   / \
                  3   6
        */
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6, node6, node7);
        TreeNode root = new TreeNode(5, node2, node3);

        System.out.println(new IsValidBST().isValidBST(root));
    }

    /**
     * 递归中序遍历
     * 根据二叉搜索树的定义，我们可以从中序遍历中得到结点从小到大依次排列的结果，
     * 所以，如果只要有一个结点比前一个结点小，代表不符合二叉搜索树的定义。
     * @param root 一开始是根结点，不断深入左子树或者右子树
     */
    // 定义一个前一个结点的值
    TreeNode preNode;
    public boolean isValidBST(TreeNode root) {
        // 1. 明确的知道递归的终止条件
        // 如果结点为空，直接返回true
        if(root == null) {
            return true;
        }
        // 2.当前函数需要做什么事情，并提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 根据左中右，验证遍历的结点是不是从小到大。
        // 具体步骤依次根据前一个结点和当前结点比较，如果当前结点比前一个结点还小，不满足二叉搜索树的定义，直接返回false

        // 比较左子树
        if(!isValidBST(root.left)){
            return false;
        }

        // 比较当前结点值和前一个结点的值
        // preNode为null，代表还未找到最左结点，即最小的值
        if(preNode != null && root.val <= preNode.val) {
            return false;
        }

        // 赋值，记录前一个结点
        preNode = root;

        // 比较右子树
        return isValidBST(root.right);
    }
}