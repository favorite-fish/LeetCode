package com.ygt.day11;

/**
 * 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * @author ygt
 * @since 2024/8/22
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println("验证回文串的答案：" + new IsPalindrome().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        // 1. 先移除所有非字母数字字符并转换小写，得到一个真正的字符串；
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 2. 创建双指针，一个在前，一个在后，前后比对，一直到相遇，期间只要不同就返回false，否则返回true。
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}