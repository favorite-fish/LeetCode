package com.ygt.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/description/
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * @author ygt
 * @since 2024/8/22
 */
public class Convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println("Z 字形变换的答案：" + new Convert().convert(s, 3));
        System.out.println("Z 字形变换的答案：" + new Convert().convert2(s, 3));
    }

    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }

        /*
        原字符串：PAYPALISHIRING  numRows：3,4,5

            P   A   H   N  -->  0     4     8      12
            A P L S I I G  -->  1  3  5  7  9  11  13
            Y   I   R      -->  2     6    10

            P     I    N   -->  0       6         12
            A   L S  I G   -->  1    5  7     11  13
            Y A   H R      -->  2  4    8  10
            P     I        -->  3       9

            P      H      -->  0         8
            A    S I      -->  1      7  9
            Y   I  R      -->  2    6   10
            P L    I G    -->  3  5     11  13
            A      N      -->  4        12

            这我们能得到什么样的规律：
            可以看到层数 是我们的 numRows把，这个没问题吧
            那每层中的每一列的怎么表示呢 先得出结果，看看是不是符合这个规律
            n 表示 numRows， i 表示行数 即 0 -> numRows
            竖的一列呢，总是以一定的间距移动：gap = 2*n - 2 ==> 0 -> 6 -> 12 -> 18
            可能中间的列需要额外计算：做两个交替，
                    1 -> 5 -> 7 -> 11
            gap-2*i -> 2*i -> gap-2*i -> 2*i
            即 间距是   4 -> 2 -> 4 -> 2

         */

        StringBuilder sb = new StringBuilder();
        int size = s.length();

        // 定义两个公式
        int gap = 2*numRows-2;
        // 定义每一行需要取对应字符串的索引
        int index = 0;
        // 间距
        int next = 0;

        // 按层数遍历
        for (int i = 0; i < numRows; i++) {

            // 重新初始化
            index = i;
            next = i * 2;
            while (index < size) {
                // 先存储第一列
                sb.append(s.charAt(index));

                // 根据间距存储
                next = gap - next; // 第一次是不是就是gap - 2*i => 第二次 gap - (gap - 2*i) => 第三次就还是 gap - 2*i

                // 下一个间距
                index += (i == 0 || i == numRows - 1) ? gap : next;

            }
        }

        return sb.toString();
    }

    // 思路2：利用集合
    public String convert2(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        /*

           | P     I    N
           | A   L S  I G
           | Y A   H R
           | P     I
         */

        int i = 0;

        // z变换的关键
        boolean flag = false;

        List<StringBuilder> result = new ArrayList<>(numRows);
        for (int j = 0; j < numRows; j++) {
            result.add(new StringBuilder());
        }
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            result.get(i).append(ch);

            if(i == 0 || i == numRows - 1){
                // 箭头变换
                flag = !flag;
            }
            // 箭头变化，就加或者减
            i += flag? 1 :-1;
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder res : result) {
            sb.append(res);
        }

        return sb.toString();
    }
}