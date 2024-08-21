package com.ygt.day9;

import java.util.HashMap;

/**
 * 217. 存在重复元素
 * https://leetcode.cn/problems/contains-duplicate/description/
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * @author ygt
 * @since 2024/8/20
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        // 建立哈希表存储
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 只要存在相同的，就直接返回true
            if(map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}