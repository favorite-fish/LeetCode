package com.ygt.day2;

/**
 * 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/description/
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 输入：x = 4
 * 输出：2
 * @author ygt
 * @since 2024/8/12
 */
public class MySqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println("x 的平方根的答案：" + new MySqrt().mySqrt(x));
    }

    /*方式：从数组中间对半分，中间值与目标值比较，小了就往左，大了往右*/
    public int mySqrt(int x) {
        // 从0开始，到目标值x处
        int left = 0, right = x, result = -1;

        // 思路:判断中间值的平方与x的大小，然后不断缩小上下界的范围。
        while(left <= right) {
            // 注意：为了避免乘法溢出
            int mid = (right - left) / 2 + left;

            // 是否比x小，只要找到第一个比x小的，代表找到了。
            if((long)mid * mid <= x) {
                result = mid;
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }
}