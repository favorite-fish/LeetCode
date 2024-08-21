package com.ygt.day9;

import java.util.HashMap;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/description/
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * @author ygt
 * @since 2024/8/20
 */
public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(new CanConstruct().canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 1. 建立哈希表
        HashMap<Character, Integer> map = new HashMap<>();

        // 2. 遍历magazine中的字符串，如果存在相同的，值+1；
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 3. 遍历ransomNote中的字符串
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            // 判断是否小于0
            if(map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}