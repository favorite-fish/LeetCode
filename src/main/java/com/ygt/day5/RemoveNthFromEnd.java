package com.ygt.day5;

import com.ygt.day4.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @author ygt
 * @since 2024/8/15
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        // 测试反转链表
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode list = new RemoveNthFromEnd().removeNthFromEnd(node, 2);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(list);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        // 1. 创建一个虚拟头结点并指向head结点；
        // 为避免出现 删除结点刚好是第一个的情况
        ListNode dummyNode = new ListNode(-1, head);

        // 主要思路：让一个指针fast先走N步，然后创建一个指针slow和fast一起走，直到fast遇到了null，
        // 这时slow就是倒数第 N 个结点的前一个结点；

        ListNode fastNode = dummyNode;
        // 在移动过程中，必须额外判断是否有为空的情况。
        for (int i = 0; i < n && fastNode.next != null; i++) {
            fastNode = fastNode.next;
        }

        ListNode slowNode = dummyNode;
        while (fastNode.next != null) {
            // 一起移动，直到fast遇到null
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        // 删除
        slowNode.next = slowNode.next.next;

        return dummyNode.next;
    }
}