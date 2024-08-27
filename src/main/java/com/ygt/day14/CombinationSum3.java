package com.ygt.day14;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode.cn/problems/combination-sum-iii/description/
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * @author ygt
 * @since 2024/8/26
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println("组合总和 III的答案：" + new CombinationSum3().combinationSum3(2, 18));
    }

    // 定义两个全局变量
    // 最终结果集合
    List<List<Integer>> result = new ArrayList<>();
    // 路径集合存放符合条件变量
    Deque<Integer> path = new LinkedList<>();
    // 总和
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(n, k, 1);
        return result;
    }

    private void backTrack(int n, int k, int start) {
        // 增加另一个剪枝操作
        if(sum > n) {
            // 如果相加和已经比目标和大了，就没必要继续递归下去了。
            return;
        }

        // 1. 终止条件
        // 找到符合条件的路径，即path的长度等于k
        if(path.size() == k) {
            // 如果path的值相加等于目标值，就可以存储
            if(sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 2. 缩减范围 -->注意：只使用数字1到9
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            // 总和相加
            sum += i;
            path.add(i);

            // 递归
            backTrack(n, k, i+1);

            // 回溯，撤销操作
            sum -= i;
            path.removeLast();
        }
    }
}