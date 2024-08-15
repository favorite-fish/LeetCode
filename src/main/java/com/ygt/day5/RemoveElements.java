package com.ygt.day5;

import com.ygt.day4.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * @author ygt
 * @since 2024/8/15
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node22 = new ListNode(6, node3);
        ListNode node2 = new ListNode(2, node22);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode list = new RemoveElements().removeElements(node, 6);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(list);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 1. 创建一个虚拟头结点并指向head结点；
        // 为避免出现 删除结点刚好是第一个的情况
        ListNode dummyNode = new ListNode(-1, head);

        // 前一个结点
        ListNode preNode = dummyNode;

        while (preNode.next != null) {
            // 开始判断
            if(preNode.next.val == val) {
                // 相同
                preNode.next = preNode.next.next;
            }else {
                // 不同
                preNode = preNode.next;
            }
        }
        return dummyNode.next;
    }
}