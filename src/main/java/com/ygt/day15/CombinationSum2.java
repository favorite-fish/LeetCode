package com.ygt.day15;

import java.util.*;

/**
 * 40. 组合总和 II
 * https://leetcode.cn/problems/combination-sum-ii/
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * @author ygt
 * @since 2024/8/27
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println("组合总和 II的答案：" + new CombinationSum2().combinationSum2(candidates, 8));
    }

    // 定义两个全局变量
    // 最终结果集合
    List<List<Integer>> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<Integer> path = new LinkedList<>();
    // 总和
    int sum = 0;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 去重逻辑前需要
        Arrays.sort(candidates);
        // 判断数组的数是否使用过
        boolean[] flag = new boolean[candidates.length];
        backTrack(candidates, target, 0, flag);
        return result;
    }

    private void backTrack(int[] candidates, int target, int start, boolean[] flag) {
        // 1. 终止条件
        // 如果总和比目标和大，直接返回
        if (sum > target) {
            return;
        }

        // 如果总和比目标相等，添加集合
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 2. 缩减范围
        for (int i = start; i < candidates.length; i++) {

            // 需要去重
            // 怎么判断是树的树枝即竖 和 树的树层即横 （1，1，6）和（1，7）的区别
            // 所以需要额外一个数组去确定 --> 在外层定义，方法传入
            if(i > 0 && candidates[i] == candidates[i-1] && !flag[i-1]) {
                continue;
            }

            // 存入当前索引值
            path.add(candidates[i]);
            sum += candidates[i];
            // 当前数字代表使用过
            flag[i] = true;

            // 递归
            backTrack(candidates, target, i+1, flag);

            // 回溯
            path.removeLast();
            sum -= candidates[i];
            flag[i] = false;
        }
    }
}