package com.ygt.day10;

/**
 * 541. 反转字符串 II
 * https://leetcode.cn/problems/reverse-string-ii/description/
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * @author ygt
 * @since 2024/8/21
 */
public class ReverseStr {
    public static void main(String[] args) {
        String s = "abcdefg";

        System.out.println("反转字符串 II 的答案：" + new ReverseStr().reverseStr(s, 2));
    }

    public String reverseStr(String s, int k) {
        if( s == null || s.equals("") ) {
            return s;
        }

        // 先转换为字符数组
        char[] chars = s.toCharArray();
        int length =  chars.length;


        // 循环遍历，每次跳跃为2k距离
        for (int i = 0; i < length; i += 2*k) {
            // 剩余字符的大小
            int right = Math.min(i + k, length) - 1;
            reverseString(chars, i, right);
        }

        return new String(chars);
    }

    // 下面就是反转的方法。
    public void reverseString(char[] s, int left, int right) {
        while (left < right){
            swap(s, left++, right--);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}