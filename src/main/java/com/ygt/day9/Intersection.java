package com.ygt.day9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/description/
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集
 *  。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * @author ygt
 * @since 2024/8/20
 */
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(new Intersection().intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // 建立两个哈希表
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 第一个哈希表存储nums1中的所有的元素
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        // 第二个哈希表是在遍历nums2时，存储与哈希表1出现过的元素。
        for (int i = 0; i < nums2.length; i++) {
            if(set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        // 最后判断set2元素是否不为空
        if(set2.size() <= 0) {
            return new int[0];
        }

        // 将set2转换为数组返回
        return set2.stream().mapToInt( i -> i).toArray();
    }
}