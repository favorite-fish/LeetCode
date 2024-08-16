package com.ygt.day6;

import com.ygt.day4.ListNode;

/**
 * 876. 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 *
 * @author ygt
 * @since 2024/8/16
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode listNode = new MiddleNode().middleNode(node);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(listNode);
    }

    public ListNode middleNode(ListNode head) {
        // 1. 一开始都位于链表的头结点
        ListNode slow = head, fast = head;

        // 2. slow指针一次只走 1 步，fast指针一次只走 2 步
        // 这样肯定是fast先到链表的尾部
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 返回慢结点就是中间结点了。
        return slow;
    }
}
