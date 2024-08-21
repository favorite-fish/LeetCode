package com.ygt.day10;

import java.util.Arrays;

/**
 * 344. 反转字符串
 * https://leetcode.cn/problems/reverse-string/description/]
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @author ygt
 * @since 2024/8/21
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new ReverseString().reverseString(s);
        System.out.println("反转字符串的答案：" + Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        if(s == null || s.length <= 1) {
            return;
        }
        // 1. 定义双指针，一个位于字符数组的开头left，一个位于字符数组的末尾right；
        int left = 0, right = s.length-1;

        // 2. left与right交换值，left右移，right左移，一直循环到两个指针相遇。
        while (left < right) {
            swap(s, left++, right--);
        }

    }

    // 交换方法
    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}