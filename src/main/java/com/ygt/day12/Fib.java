package com.ygt.day12;

/**
 * 509. 斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/description/
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *climbStairs
 * @author ygt
 * @since 2024/8/23
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println("斐波那契数为6时的结果：" + new Fib().fib(6));
    }

    public int fib(int n) {
        // 1. 明确的知道递归的终止条件
        // 从题目中可以得到，当n=1或者n=0时，就可以直接返回结果n。
        if (n <= 1) {
            return n;
        }

        // 2. 当前函数需要做什么事情，并提取重复的逻辑，不断缩小问题规模的一个关系表达式
        //   我们可以轻易知道这道题，我们是在传入什么参数时，求出参数对应项的值，并给通过上面的给出的公式，
        //   我们也得出我们需要不断重复，不断减小的一个关系式`F[n] = F[n-1] + F[n-2]`。

        return fib(n - 1) + fib(n - 2);
    }
}