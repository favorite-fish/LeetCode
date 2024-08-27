package com.ygt.day15;

import java.util.*;

/**
 * 47. 全排列 II
 * https://leetcode.cn/problems/permutations-ii/description/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @author ygt
 * @since 2024/8/27
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println("全排列 II的答案：" + new PermuteUnique().permuteUnique(nums));
    }

    // 定义两个全局变量
    // 最终结果集合
    List<List<Integer>> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 判断数组的数是否使用过
        boolean[] used = new boolean[nums.length];
        // 排序数组
        Arrays.sort(nums);
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

            // 增加一个去重判断。
            if(i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
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