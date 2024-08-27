package com.ygt.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * @author ygt
 * @since 2024/8/27
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println("电话号码的字母组合的答案：" + new LetterCombinations().letterCombinations(""));
    }

    // 定义两个全局变量
    // 最终结果集合
    List<String> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    StringBuilder path = new StringBuilder();
    // 字符串与数字的映射关系
    //         索引   0   1     2      3      4      5      6      7       8      9
    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backTrack(digits, 0);
        return result;
    }

    private void backTrack(String digits, int index) {
        // 1. 终止条件
        // 找到符合条件的路径，即path的长度等于end
        if(digits.length() == index) {
            // 存储结果
            result.add(path.toString());
            return;
        }

        // 先得到对应目标字符digits的索引
        int pos = digits.charAt(index) - '0';
        // 得到当前索引下的字符串
        String digit = phone[pos];

        // 2. 缩减范围
        for (int i = 0; i < digit.length(); i++) {
            // 存入字符串
            path.append(digit.charAt(i));
            // 递归
            backTrack(digits, index + 1);
            // 回溯，撤销操作
            path.deleteCharAt(path.length() - 1);
        }
    }
}