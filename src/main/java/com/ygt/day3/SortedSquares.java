package com.ygt.day3;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * @author ygt
 * @since 2024/8/13
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println("有序数组的平方的答案：" + Arrays.toString(new SortedSquares().sortedSquares(nums)));

    }

    /*主要解题思路：需要掌握双指针*/
    public int[] sortedSquares(int[] nums) {
        // 需要注意的一点是，原先为负数的值，平方后，可能反而变大。
        // 实现的关键还是双指针， 实现思路：前后比较，从后不断填充大的值。

        int left = 0, right = nums.length - 1;
        // 需要一个新数组来实现，不断填充数据。
        int[] result = new int[nums.length];
        int resultIndex = right;
        while (left <= right){
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];

            // 比较大小，谁大，填充谁的数据，并移动指针。
            if(leftValue > rightValue) {
                result[resultIndex] = leftValue;
                left ++;
            }else {
                result[resultIndex] = rightValue;
                right --;
            }
            resultIndex --;
        }
        return result;
    }
}
