package com.ygt.day2;

/**
 * 704. 二分查找
 * https://leetcode.cn/problems/binary-search/description/
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * @author ygt
 * @since 2024/8/12
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println("二分查找的答案：" + new Search().search(nums, 9));
    }

    /*方式：从数组中间对半分，中间值与目标值比较，小了就往左，大了往右*/
    public int search(int[] nums, int target) {
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

        return -1;
    }
}
