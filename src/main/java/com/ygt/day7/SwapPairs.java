package com.ygt.day7;

import com.ygt.day4.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * @author ygt
 * @since 2024/8/17
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode listNode = new SwapPairs().swapPairs(node);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // 1. 创建虚拟头结点
        ListNode dummyNode = new ListNode(-1, head);
        ListNode curNode = dummyNode.next, preNode = dummyNode;

        // 循环交换
        while (curNode != null) {
            // 需要判断是否还有后续结点
            if(curNode.next != null) {
                // 交换
                ListNode nextNode = curNode.next;
                curNode.next = nextNode.next;
                nextNode.next = preNode.next;
                preNode.next = nextNode;
            }

            // 最后复位
            preNode = curNode;
            curNode = curNode.next;
        }

        return dummyNode.next;
    }
}