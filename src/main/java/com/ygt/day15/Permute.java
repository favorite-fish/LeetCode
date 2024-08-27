package com.ygt.day15;

import java.util.*;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/description/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * @author ygt
 * @since 2024/8/27
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println("全排列的答案：" + new Permute().permute(nums));
    }

    // 定义两个全局变量
    // 最终结果集合
    List<List<Integer>> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 判断数组的数是否使用过
        boolean[] used = new boolean[nums.length];
        backTrack(nums, 0, used);
        return result;
    }

    private void backTrack(int[] nums, int start, boolean[] used) {
        // 1. 终止条件
        // 如果路径集合等于了nums数组大小
        if (nums.length == path.size()) {
            // 存储结果
            result.add(new ArrayList<>(path));
            return;
        }

        // 2. 缩减范围 --> 注意每次递归进来都是从0开始。注意这里的区别
        for (int i = 0; i < nums.length; i++) {

            // 需要判断当前元素是否被使用过了，使用就跳过
            if(used[i]) {
                continue;
            }

            // 存入当前索引值
            path.add(nums[i]);

            // 当前数字代表使用过
            used[i] = true;

            // 递归
            backTrack(nums,i+1, used);

            // 回溯
            path.removeLast();
            used[i] = false;
        }
    }
}