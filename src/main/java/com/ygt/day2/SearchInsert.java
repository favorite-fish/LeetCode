package com.ygt.day2;
/**
 * 35. 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/description/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * @author ygt
 * @since 2024/8/12
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println("搜索插入位置的答案：" + new SearchInsert().searchInsert(nums, 5));
    }

    /*方式：从数组中间对半分，中间值与目标值比较，小了就往左，大了往右*/
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
        }

        // 与二分查找的区别，无非就是题目中，所说，如果目标值不存在于数组中，返回它将会被按顺序插入的位置，即已经在末尾或者开始处。
        return left;
    }
}
