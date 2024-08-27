package com.ygt.day14;

import java.util.*;

/**
 * 77. 组合
 * https://leetcode.cn/problems/combinations/description/
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * @author ygt
 * @since 2024/8/26
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println("组合的答案：" + new Combine().combine(4, 2));
        System.out.println("组合的答案2：" + new Combine().combine2(4, 2));
    }

    // 定义两个全局变量
    // 最终结果集合
    List<List<Integer>> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return result;
    }

    public List<List<Integer>> combine2(int n, int k) {
        backTrack2(n, k, 1);
        return result;
    }

    private void backTrack(int n, int k, int start) {
        // 1. 终止条件
        // 找到符合条件的路径，即path的长度等于k
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 2. 缩减范围
        for (int i = start; i <= n; i++) {
            path.add(i);

            // 开始递归下一轮的搜索
            backTrack(n, k, i + 1);

            // 回溯，对栈顶的元素弹出，撤销之前元素
            path.removeLast();
        }
    }

    // 回溯剪枝操作
    private void backTrack2(int n, int k, int start) {
        // 1. 终止条件
        // 找到符合条件的路径，即path的长度等于k
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 2. 缩减范围 n 修改为 n - (k - path.size()) + 1
        // 意思是至多从start 到 n - (k - path.size()) + 1 开始，即后续的递归是没意义的。
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);

            // 开始递归下一轮的搜索
            backTrack2(n, k, i + 1);

            // 回溯，对栈顶的元素弹出，撤销之前元素
            path.removeLast();
        }
    }
}