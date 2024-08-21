package com.ygt.day10;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * @author ygt
 * @since 2024/8/21
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("找出字符串中第一个匹配项的下标的暴力破解法：" + new StrStr().strStr(haystack, needle));
        System.out.println("找出字符串中第一个匹配项的下标的kmp：" + new StrStr().strStr2(haystack, needle));
    }

    /*暴力破解法*/
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // 如果模式串的长度比主串的长度还长，就不用匹配了。
        if(n < m) {
            return -1;
        }

        for (int i = 0; i <= (n - m); i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                // 不断比较
                char ch = haystack.charAt(i+j);
                char ch2 = needle.charAt(j);
                if(ch2 != ch) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                return i;
            }
        }
        return -1;
    }

    /*kmp优化算法*/
    public int strStr2(String haystack, String needle) {
        // 主串长度
        int n = haystack.length();
        // 模板串长度
        int m = needle.length();

        if(n < m) {
            return -1;
        }

        // 构建next数组
        int[] nextArr = getNextArr(needle);

        // 模板串的指针j
        int j = 0;

        // 主串的指针i
        for (int i = 0; i < n; i++) {
            // 主串当前字符
            char c1 = haystack.charAt(i);

            // 如果不匹配，j回溯前一个索引的next值（跟构建next数组类似吧）
            while (j > 0 && c1 != needle.charAt(j) ) {
                j = nextArr[ j - 1];
            }

            // 匹配就j++
            if(c1 == needle.charAt(j)) {
                j++;
            }

            // 完全遍历结束，j == m 时，代表完全匹配成功
            if(j == m) {
                // 返回最开始的i处 需要 + 1
                return i - m + 1;
            }
        }
        // 循环结束，还没匹配的，表示匹配失败
        return -1;
    }

    public int[] getNextArr(String needle) {
        // 以字符串的长度来构建next数组
        int size = needle.length();
        int[] next = new int[size];

        // 默认为0
        int nextValue = 0;
        // 默认next数组索引0处的值就是0
        next[0] = nextValue;

        // 索引1处开始遍历
        for (int i = 1; i < size; i++) {
            // 匹配不成 回溯到前一个字符串，直到能够匹配或者是到索引0处
            while (nextValue > 0 && needle.charAt(i) != needle.charAt(nextValue)){
                nextValue = next[nextValue - 1];
            }

            //相等，相当于当前索引处能够跳过的长度。
            if(needle.charAt(i) == needle.charAt(nextValue)){{
                nextValue++;
            }}

            next[i] = nextValue;
        }

        return next;
    }
}
