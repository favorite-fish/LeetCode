package com.ygt.day9;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/description/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * @author ygt
 * @since 2024/8/20
 */
public class IsAnagram {
    public static void main(String[] args) {
        new IsAnagram().isAnagram("anagram", "nagaram");
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if(map.get(ch) < 0) {
                return false;
            }
        }

        return true;
    }
}