package com.ygt.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * https://leetcode.cn/problems/hanota-lcci/
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 * 输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * @author ygt
 * @since 2024/8/23
 */
public class Hanota {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        new Hanota().hanota(A, B, C);

        System.out.println(C);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    private void move(int num, List<Integer> A, List<Integer> B, List<Integer> C) {
        // 1. 明确终止条件
        //只剩一个，就直接移动就行了。
        if(num == 1) {
            C.add(A.remove(A.size()-1));
            return;
        }

        // 2. 当前函数需要做什么事情提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 我们是在需要计算不同参数的对应的一个汉诺塔的一个步骤即A --> C，从步骤来看：
        // 1. 当我们A有n个的时候，需要移动n -1 到 B中，需要借助C，
        move(num - 1, A , C, B);

        // 2. 把A的最下面的即n即最后一个，移动到我们C中
        C.add(A.remove(A.size()-1));

        // 3. 接下来就是重复之前的动作把B中的n -1 个移动到C中即可，借助A
        move(num - 1, B , A, C);
    }
}