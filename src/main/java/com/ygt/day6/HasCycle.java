package com.ygt.day6;

import com.ygt.day4.ListNode;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/description/
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * @author ygt
 * @since 2024/8/16
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 形成环
//        node5.next = node2;
        // 这个有环的打印不了一点。
        System.out.println(new HasCycle().hasCycle(node));
    }

    public boolean hasCycle(ListNode head) {
        // 主要思路：
        // 通过快慢指针，快指针每次移动两步，而慢指针每次移动一步，只要链表有环，终究会相遇的。

        // 定义快慢指针，一开始为head头结点的位置
        ListNode fast = head, slow = head;

        // 如果能找到末尾null的位置，代表着这个链表是无环的，退出循环即可，返回false
        while(fast != null && fast.next != null) {
            // 快指针走两步，而慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
            // 如果相等，代表两个相遇，代表有环
            if(fast == slow) {
                return true;
            }
        }

        return false;
    }
}