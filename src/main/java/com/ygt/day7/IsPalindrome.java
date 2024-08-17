package com.ygt.day7;

import com.ygt.day4.ListNode;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表.如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 * @author ygt
 * @since 2024/8/17
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        System.out.println(new IsPalindrome().isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        // 1. 找到中间结点
        // 注意，fast = head.next，为了找到在偶数的中间结点的前一个结点，方便反转。
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2. 反转后半部分
        ListNode preNode = slow, curNode = slow.next;
        while (curNode.next != null) {
            ListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = preNode.next;
            preNode.next = nextNode;
        }

        // 3. 一一比较
        ListNode firstNode = head;
        while ((preNode = preNode.next) != null) {
            if(firstNode.val != preNode.val) {
                return false;
            }
            firstNode = firstNode.next;
        }

        return true;
    }
}