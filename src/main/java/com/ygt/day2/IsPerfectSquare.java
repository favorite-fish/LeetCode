package com.ygt.day2;

/**
 * 367. 有效的完全平方数
 * https://leetcode.cn/problems/valid-perfect-square/description/
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如  sqrt 。
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * @author ygt
 * @since 2024/8/12
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        int num = 13;
        System.out.println("有效的完全平方数：" + new IsPerfectSquare().isPerfectSquare(num));
    }

    /*方式：二分查找的模板*/
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        // 思路与上一道题（x 的平方根）类似，判断中间值的平方与x的大小，然后不断缩小上下界的范围。
        // 区别在于 平方后要精准相等，才是有效的完全平方数。
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            long value = (long)mid * mid;
            if(value < num) {
                left = mid+1;
            }else if(value > num){
                right = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}