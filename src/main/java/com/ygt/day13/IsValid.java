package com.ygt.day13;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * @author ygt
 * @since 2024/8/25
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "([)]{}";
        System.out.println("有效的括号：" + new IsValid().isValid(s));
    }

    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            // 长度单数直接false;
            return false;
        }

        // 存储括号相关的哈希表
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        // 使用栈辅助
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(map.get(c));
            }else if(stack.isEmpty() || stack.pop() != c){
                // 如果是右括号开始的，直接返回false
                return false;
            }
        }
        return stack.isEmpty();
    }
}