package com.ygt.day3;

/**
 * 674. 最长连续递增序列
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * @author ygt
 * @since 2024/8/13
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println("最长连续递增序列的答案：" + new FindLengthOfLCIS().findLengthOfLCIS(nums));
    }

    /*主要解题思路：需要掌握双指针和滑动窗口*/
    public int findLengthOfLCIS(int[] nums) {
        // 滑动窗口的思想就是双指针，根据需要不断扩大指针，从而达到一个窗口的目的。
        /*
                           f一直移动到4,最大为3  s重新替换为4处，f一直移动到7,最大为2
            [1,3,5,4,7]     [1,3,5,4,7]         [1,3,5,4,7]
             s               s                         s
               f                   f                     f
             所以最终最大为3
         */

        int slow = 0 , fast = 1, max = 1;

        while (fast < nums.length) {
            // fast只要是比前面位置小或者相等，就不是递增序列，可以判断当前的最长连续递增序列
            if(nums[fast-1] >= nums[fast]){
                slow = fast;
            }
            fast++;
            max = Math.max(max, (fast - slow));
        }

        return max;
    }

}
