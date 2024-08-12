package com.ygt.day1;

import java.util.HashMap;

/**
 * 1. 两数之和
 * https://leetcode.cn/problems/two-sum/description/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @author ygt
 * @since 2024/8/12
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println("两数之和的答案：" + new TwoSum().twoSum(nums, 9));
    }

    /*方式1：暴力破解法*/
    public int[] twoSum(int[] nums, int target) {
        // 直接双层for循环遍历判断即可
        int[] result = new int[2];

        // 先判断下
        if(nums == null || nums.length < 2) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            // 与后面一个逐一比较判断
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                // 如果相等就可以设置数组并退出循环
                if(first + second ==  target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
    /*方式2：使用哈希表*/
    public int[] twoSum2(int[] nums, int target) {
        // 通过一层for循环，不断判断哈希表是否有满足条件的值，有直接返回
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // 判断 target减去当前的值后，哈希表是否有值存在
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}