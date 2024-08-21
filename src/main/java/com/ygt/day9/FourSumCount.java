package com.ygt.day9;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 * https://leetcode.cn/problems/4sum-ii/description/
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * @author ygt
 * @since 2024/8/20
 */
public class FourSumCount {
    public static void main(String[] args) {
        int[] nums1 = {-1, -1};
        int[] nums2 = {-1, 1};
        int[] nums3 = {-1, 1};
        int[] nums4 = {1, -1};
        System.out.println(new FourSumCount().fourSumCount(nums1, nums2, nums3, nums4));

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 建立一个哈希表存储第一组的和
        HashMap<Integer, Integer> map = new HashMap<>();

        // 先求出nums1和nums2的和
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 最终返回的数量
        int result = 0;

        // 求出nums3和nums4的和
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = -(nums3[i] + nums4[j]);
                // 判断相反的sum是否在哈希表中存在
                if(map.containsKey(sum)) {
                    // 这样应该是加上map中出现的次数
                    result += map.get(sum);
                }
            }
        }

        return result;
    }
}