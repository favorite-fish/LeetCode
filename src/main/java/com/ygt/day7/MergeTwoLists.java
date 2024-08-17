package com.ygt.day7;

import com.ygt.day4.ListNode;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * @author ygt
 * @since 2024/8/17
 */
public class MergeTwoLists {
    public static void main(String[] args) {

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // 打印查看当前效果
            ListNode.print(node);

        ListNode listNode = new MergeTwoLists().mergeTwoLists(node, node2);
            System.out.println();

        // 打印查看当前效果
            ListNode.print(listNode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 判断两个链表是否为空
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        // 1. 创建虚拟头结点，作为合并后的新链表头结点的前一个结点
        ListNode dummyNode = new ListNode(-1);

        ListNode head = dummyNode;

        // 2. 比较两个链表的每一个结点的大小，小的就添加到新链表的末尾处，直到某一个链表已经遍历结束；
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        // 3. 最后补充剩余结点链表到新链表的末尾。
        head.next = list1 == null ? list2: list1;
        return dummyNode.next;
    }
}