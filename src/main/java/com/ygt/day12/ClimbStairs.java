package com.ygt.day12;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/description/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * @author ygt
 * @since 2024/8/23
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println("爬8层楼梯的结果：" + new ClimbStairs().climbStairs(8));
    }

    public int climbStairs(int n) {
        // 1. 明确的知道递归的终止条件
        //   从数列我们也可以看出，当n = 1或者n = 0时，就返回结果1。
        if(n <= 1) {
            return 1;
        }

        //2. 当前函数需要做什么事情，并提取重复的逻辑，不断缩小问题规模的一个关系表达式
        //   我们可以轻易知道这道题，我们是在传入什么参数时，求出参数对应项的有多少中走法即求出对应项的值，
        //   而对于上面的给出的公式，我们也可以得出不断减小的一个关系式F[n] = F[n-1] + F[n-2]。

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}