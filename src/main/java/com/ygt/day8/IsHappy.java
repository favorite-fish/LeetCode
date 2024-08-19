package com.ygt.day8;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * https://leetcode.cn/problems/happy-number/description/
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author ygt
 * @since 2024/8/19
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println("快乐数：" +new IsHappy().isHappy(19));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        // 判断当前数字是否等于1，并且是否在哈希表重复出现
        while (n != 1 && !set.contains(n)) {
            // 存储当前数字到集合中
            set.add(n);
            // 求出当前数字的下一个数字
            n = getNum(n);
        }

        // 退出循环后，判断是否等于1，因为可能是哈希表重复值退出循环的
        return n == 1;
    }

    private int getNum(int n) {
        // 进行数位分离后求平方和
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            sum += num * num;
        }

        return sum;
    }
}