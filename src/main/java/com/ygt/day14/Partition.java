package com.ygt.day14;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串。返回 s 所有可能的分割方案。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * @author ygt
 * @since 2024/8/27
 */
public class Partition {
    public static void main(String[] args) {
        System.out.println("分割回文串的答案：" + new Partition().partition("aab"));
    }
    // 定义两个全局变量
    // 最终结果集合
    List<List<String>> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        backTrack(chars, 0, s.length());
        return result;
    }

    /**
     * @param chars 目标字符数组
     * @param start 起始索引，即切割的线
     * @param end 字符串的长度，即当起始索引 == 字符串的长度 的话，代表已经切割完成。
     */
    private void backTrack(char[] chars, int start, int end) {
        // 1. 终止条件
        // 找到符合条件的路径，即path的长度等于k
        if(start == end) {
            // 存储结果
            result.add(new ArrayList<>(path));
            return;
        }

        // 2. 缩减范围
        for (int i = start; i < end; i++) {
            // 判断是不是回文串，如果是，才进行递归操作
            // 如何确定一个子串呢
            /*
                a| a b  -->     起始      i = 0, start = 0
                a a| b  --> 随着for循环i++ i = 1, start = 0
                a a b|  --> 随着for循环i++ i = 2, start = 0
                可以看出子串的范围：【start,i】
             */
            if(!isPalindrome(chars, start, i)) {
                // 不是回文，跳过当前递归，到下一个i，即下一个子串判断
                continue;
            }

            path.addLast(new String(chars, start, i + 1 - start));
            // 递归
            backTrack(chars, i + 1, end);
            // 回溯，撤销操作
            path.removeLast();
        }
    }

    // 验证回文串
    public boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if(chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}