package com.ygt.day6;

import com.ygt.day4.ListNode;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 自定义评测：
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，
 * 那么你的解决方案将被 视作正确答案 。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
 * 换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
 * @author ygt
 * @since 2024/8/16
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode node6 = new ListNode(4);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(8, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node = new ListNode(5, node2);

        ListNode node22 = new ListNode(1, node4);
        ListNode node11 = new ListNode(4, node22);

        System.out.println("相交的结点值：" + new GetIntersectionNode().getIntersectionNode(node, node11).val);
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 判断条件
        if(headA == null || headB == null) {
            return null;
        }

        // 定义两个指针，分别指向两个链表的头结点
        ListNode a = headA;
        ListNode b = headB;

        // 依次往后遍历 直到遇到两个结点相等
        while (a != b) {
            // 1. 如果 a 到了末尾，则 a = headB 继续往后遍历；
            a = a == null ? headB : a.next;
            // 2. 如果 b 到了末尾，则 b = headA 继续往后遍历；
            b = b == null ? headA : b.next;
        }

        return a;
    }
}