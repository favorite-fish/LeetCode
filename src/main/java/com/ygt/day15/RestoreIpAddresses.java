package com.ygt.day15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode.cn/problems/restore-ip-addresses/
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * @author ygt
 * @since 2024/8/27
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println("复原 IP 地址的答案：" + new RestoreIpAddresses().restoreIpAddresses("25525511135"));
    }
    // 定义两个全局变量
    // 最终结果集合
    List<String> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<String> path = new ArrayDeque<>(4);;

    public List<String> restoreIpAddresses(String s) {
        // 判断字符串的长度
        if(s == null || s.length() < 4 || s.length() > 12 ) {
            return result;
        }
        backTrack(s, 0, 0);
        return result;
    }

    /**
     * @param s
     * @param begin 控制子串范围
     * @param index 控制结点数，即深度
     */
    private void backTrack(String s, int begin, int index) {
        // 1. 终止条件
        // 层数限制在4层，即index == 4
        if(begin == s.length() && 4 == index) {
            // 存储结果
            result.add(String.join(".", path));
            return;
        }

        // 如果begin等于s的长度但是ip段的数量不为4，
        // 或者ip段的数量为4但是begin小于s的长度，则直接返回
        if (begin == s.length() || index == 4) {
            return;
        }


        // 2. 缩减范围 --> 为了防止添加过多的元素 && i - begin < 3
        for (int i = begin; i < s.length() && i - begin < 3; i++) {
            // 判断结点子串的合法性
            int vail = isVail(s, begin, i);
            if(vail != -1) {
                path.add(vail + "");
                // 递归
                backTrack(s, i+1, index+1);
                // 回溯，撤销操作
                path.removeLast();
            }else {
                // 非法就退出
                continue;
            }
        }
    }

    public int isVail(String s, int left, int right) {
        int length = right - left + 1;

        if(length > 3) {
            return -1;
        }

        // 不能以0开头
        if(length > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 判断大小
        // 转成 int 类型
        int num = 0;
        for (int i = left; i <= right; i++) {
            num = num * 10 + s.charAt(i) - '0';
        }

        if (num > 255) {
            return -1;
        }
        return num;
    }
}