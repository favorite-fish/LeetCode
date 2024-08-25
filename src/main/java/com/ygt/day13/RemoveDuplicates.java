package com.ygt.day13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * @author ygt
 * @since 2024/8/25
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println("删除字符串中的所有相邻重复项：" + new RemoveDuplicates().removeDuplicates(s));
    }

    public String removeDuplicates(String s) {
        // 创建一个辅助栈
        Deque<Character> stack = new LinkedList<>();

        // 遍历字符串的字符数组
        for (char c : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}