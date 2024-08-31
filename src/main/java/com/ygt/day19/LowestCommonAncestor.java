package com.ygt.day19;


import com.ygt.day16.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 示例：
 * root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *                   3
 *                  / \
 *                 5   1
 *                / \ / \
 *               6  2 0  8
 *                 / \
 *                7  4
 * 输出结果为：3
 * @author ygt
 * @since 2024/8/31
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        /*
                        3
                       / \
                      5   1
                     / \ / \
                    6  2 0  8
                      / \
                     7  4
        */
        TreeNode node11 = new TreeNode(7);
        TreeNode node12 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2, node11, node12);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node2 = new TreeNode(5, node4, node5);
        TreeNode node3 = new TreeNode(1, node6, node7);
        TreeNode root = new TreeNode(3, node2, node3);

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, node2, node12).val);

    }

    /**
     * 递归后序遍历完全二叉树的节点个数
     * 根据左右根方式，先左右子树得到深度，最后判断当前结点是否包含着p q
     *                     3
     *                    / \
     *                   5   1
     *                  / \ / \
     *                 6  2 0  8
     *                   / \
     *                  7  4
     *  得到的为：3
     * @param root 一开始进入的是根结点，从根结点开始遍历
     * @return  返回最近公共结点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1.明确的知道递归的终止条件
        // 如果结点为空，就返回null;
        if(root == null) {
            return null;
        }

        // 如果找到了p或者q就返回当前结点
        if(root == p || root == q) {
            return root;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 根据后序遍历，左右根，查找左右子树存在p或者q的结点，并在当前结点是否同时找到了pq即为最近公共结点

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果left 和 right都不为空，代表当前结点找到pq，即就是最近公共节点。
        if(left != null && right != null) {
            return root;
        }

        // 如果left不为空，right为空，就返回left，证明当前结点还未全部找到qp；
        // 同理right不为空，一样。
        if(left != null && right == null) {
            return left;
        }else if(left == null && right != null) {
            return right;
        }else {
            // 如果都没找到，证明当前结点左右子树都没有pq。
            return null;
        }
    }
}