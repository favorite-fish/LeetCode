package com.ygt.day7;

import com.ygt.day4.ListNode;

/**
 * 61. 旋转链表
 * https://leetcode.cn/problems/rotate-list/description/
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * @author ygt
 * @since 2024/8/17
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode listNode = new RotateRight().rotateRight(node, 2);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(listNode);
    }

    public ListNode rotateRight(ListNode head, int k) {
        // 进行校验，如果k = 0或者链表为空，或者链表的next为空，都可以直接返回当前结点
        if(k == 0 || head == null || head.next == null) {
            return head;
        }

        // 在我们查看案例2的时候，可以发现一个规律，假设链表的长度为n，当向右移动次数k ≥ n时，并且k的值可能会很大，
        // 所以我们只要移动k % n次即可。而且每次n（或者n的倍数）次移动都是链表的原状态，
        // 所以推导出新链表的头节点位置为原链表的第n - (k % n)个节点(即从0开始计数)。

        // 通过第一次遍历得到链表的长度，还有链表的末尾结点
        int size = 1;
        ListNode tailNode = head;
        while(tailNode.next != null) {
            size++;
            tailNode = tailNode.next;
        }

        // 通过取模计算，重新得到k的值。
        k = k % size;

        // 判断是否为n的倍数，是就直接返回即可
        if(k == 0) {
            return head;
        }

        // 寻找链表最后第k个的结点 preNode
        ListNode preNode = head;
        // 由于当前preNode为head结点，多计算了一位，所以需要size - k - 1。
        for (int i = 0; i < (size - k - 1); i++) {
            preNode = preNode.next;
        }

        // 尾结点闭环
        tailNode.next = head;
        // 新的起始结点
        head = preNode.next;
        // 截断preNode，置为null
        preNode.next = null;
        return head;
    }
}