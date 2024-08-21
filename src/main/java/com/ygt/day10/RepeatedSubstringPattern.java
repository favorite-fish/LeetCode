package com.ygt.day10;

/**
 * 459. 重复的子字符串
 * https://leetcode.cn/problems/repeated-substring-pattern/description/
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * @author ygt
 * @since 2024/8/21
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println("重复的子字符串的答案：" + new RepeatedSubstringPattern().repeatedSubstringPattern(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        // 构造双倍字符串
        String str = s + s;
        // 判断是否出现原字符串
        return str.substring(1, str.length() - 1).contains(s);
    }
}