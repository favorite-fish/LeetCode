package com.ygt.day5;

import com.ygt.day4.ListNode;

/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * @author ygt
 * @since 2024/8/15
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode listNode = new ReverseBetween().reverseBetween(node, 2, 4);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(listNode);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1. 创建一个虚拟头结点并指向head结点；
        // 为避免出现left出现在第一个结点
        ListNode dummyNode = new ListNode(-1, head);

        // 2. 找到left位置的前一个结点preNode；
        ListNode preNode = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }

        // 3. 反转指定局部区间的链表；
        // 在找到left的前结点后，可以在left和right区间的链表进行反转了
        //  1 --> 2 --> 3 --> 4 --> 5 待反转区域为 2 --> 3 --> 4
        // 定义当前结点
        ListNode curNode = preNode.next;

        // 4. 在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置，一直反转到right位置；
        // 开始遍历反转
        for (int i = left; i < right; i++) {
            // 当前结点的next结点
            ListNode nextNode = curNode.next;
            // 将当前结点的next指向了 nextNode的next结点 即 2 --> 4
            curNode.next = nextNode.next;
            // 将nextNode的next指向了 preNode的next结点 即 3 --> 2
            nextNode.next = preNode.next;
            // 将preNode的next指向了 nextNode 即 1 --> 3
            preNode.next = nextNode;

        }
        // 5. 最后返回虚拟头结点的下一个节点。
        return dummyNode.next;
    }
}