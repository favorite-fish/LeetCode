package com.ygt.day1;

import java.util.HashMap;

/**
 * 13. 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/description/
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author ygt
 * @since 2024/8/12
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println("罗马数字转整数的答案：" + new RomanToInt().romanToInt(s));
    }

    /*方式：直接将可能的结构存储在哈希表中，最后不断取出判断*/
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>(8);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int length = s.length();

        // 需要额外注意：C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        // 就是可以理解为：前面一个数比后面的小的话，代表要减了，否则就加
        // 单独一个M为1000，而CM为900
        for (int i = 0; i < length; i++) {
            // 取出第一个值
            int value = map.get(s.charAt(i));

            // 当前字符串的索引边界判断 以及与后一个进行比较
            if(i < length - 1 && value < map.get(s.charAt(i + 1))){
                result -= value;
            }else {
                result += value;
            }
        }
        return result;
    }
}