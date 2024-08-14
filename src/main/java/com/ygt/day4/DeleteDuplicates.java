package com.ygt.day4;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * @author ygt
 * @since 2024/8/14
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(3);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode listNode = new DeleteDuplicates().deleteDuplicates(node);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        /*
            注意，这道题链表有序的，完全可以使用一次遍历就删除重复元素，
            主要思路：
            1. 使用指针 curNode指向当前head结点；
            2. 通过判断 curNode的next是否不为空；
            3. 不为空，就需要判断 curNode 和 curNode.next 两者的值是否相同，相同就得移除；不同就后移即可。
         */
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }

        return head;
    }
}