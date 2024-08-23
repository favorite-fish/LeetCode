package com.ygt.day12;

/**
 * 需求：求下5的阶乘。
 * 先分析下阶乘怎么算：
 * 当n = 1时， 1！ = 1;
 * 当n = 2时， 2！ = 2 * 1；
 * 当n = 3时， 3！ = 3 * 2 * 1；
 * 即阶乘公式：`n! = n * (n-1) * ---- * 2 * 1`。
 * @author ygt
 * @since 2024/8/23
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("5的阶乘的结果为：" + jc(5));
    }

    public static int jc(int num) {
        // 1. 明确终止条件
        if(num <= 1) {
            // 达到终止条件时，返回结果1
            return 1;
        }

        // 2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 从定义上看，我们知道当前函数是需要做参数的一个阶乘操作！ f(n) = n * f(n -1)
        // 从阶乘上来看，不变得是当前参数去相乘一个数，变的是数会不断减小1

        return num * jc(num - 1);
    }
}