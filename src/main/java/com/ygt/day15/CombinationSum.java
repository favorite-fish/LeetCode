package com.ygt.day15;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/description/
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * @author ygt
 * @since 2024/8/27
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println("组合总和的答案：" + new CombinationSum().combinationSum(candidates, 7));
    }

    // 定义两个全局变量
    // 最终结果集合
    List<List<Integer>> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<Integer> path = new LinkedList<>();
    // 总和
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0);
        return result;
    }

    private void backTrack(int[] candidates, int target, int start) {
        // 1. 终止条件
        // 如果总和比目标和大，直接返回
        if(sum > target) {
            return;
        }

        // 如果总和比目标相等，添加集合
        if(sum == target) {
            result.add(new ArrayList<>(path));
            return ;
        }

        // 2. 缩减范围
        for (int i = start; i < candidates.length; i++) {
            // 存入当前索引值
            path.add(candidates[i]);
            sum+=candidates[i];

            // 递归
            backTrack(candidates, target, i);

            // 回溯
            path.removeLast();
            sum-=candidates[i];
        }
    }
}