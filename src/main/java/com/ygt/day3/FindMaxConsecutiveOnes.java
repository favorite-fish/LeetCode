package com.ygt.day3;

/**
 * 485. 最大连续 1 的个数
 * https://leetcode.cn/problems/max-consecutive-ones/description/
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * @author ygt
 * @since 2024/8/13
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println("最大连续 1 的个数的答案：" + new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }

    /*主要解题思路：需要掌握双指针和滑动窗口*/
    public int findMaxConsecutiveOnes(int[] nums) {
        // 滑动窗口的思想就是双指针，根据需要不断扩大指针，从而达到一个窗口的目的。
        // 这道题的思路，跟上一道一样类似，无非就是判断条件改了而已，判断不等于1而已。
        int slow = 0, fast = 0, max = 0;

        while (fast < nums.length) {
            if(nums[fast] != 1) {
                slow = fast + 1;
            }
            fast++;
            max = Math.max(max, (fast - slow));
        }

        return max;
    }
}
