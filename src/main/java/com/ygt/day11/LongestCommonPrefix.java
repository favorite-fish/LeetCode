package com.ygt.day11;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/description/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * @author ygt
 * @since 2024/8/22
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("最长公共前缀的答案：" + new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        // 设定数组中的第一个字符串就是最长公共前缀，依次和数组中的后续字符串进行比对缩减
        if(strs == null || strs.length < 0) {
            return "";
        }

        String result = strs[0];

        // 所以从数组的索引1处开始
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];

            // 开始比对
            int index = 0;
            // 寻找相同的前缀
            // left 不能超过result的长度和str的长度
            while(index < result.length() && index < str.length()
            && str.charAt(index) == result.charAt(index)) {
                index++;
            }

            // 缩减
            // 如果index为0，代表已经没有匹配的，无需后续循环操作了。
            if(index == 0) {
                return "";
            }
            result = result.substring(0, index);
        }

        return result;
    }
}