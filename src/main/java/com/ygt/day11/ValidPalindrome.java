package com.ygt.day11;

/**
 * 680. 验证回文串 II
 * https://leetcode.cn/problems/valid-palindrome-ii/description/
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * 输入：s = "abc"
 * 输出：false
 * @author ygt
 * @since 2024/8/22
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "ebcbbececabbacecbbcbe";
        System.out.println("验证回文串 II的答案：" + new ValidPalindrome().validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        // 创建双指针，一个在前，一个在后，前后比对，一直到相遇，期间只要不同就返回false，否则返回true。
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // 有次机会删除一个字符 即跳过一个字符的比对
            // 两种情况， 一个从左开始，一个从右开始。
            // 所以这两种情况结束后，就能只知道是否是回文了
            if(s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left+1, right) ||
                        isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}