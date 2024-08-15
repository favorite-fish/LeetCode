package com.ygt.day5;

import com.ygt.day4.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * @author ygt
 * @since 2024/8/15
 */
public class DeleteDuplicates {
    public static void main(String[] args) {

        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode listNode = new DeleteDuplicates().deleteDuplicates(node);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        // 1. 创建一个虚拟头结点并指向head结点；
        // 为避免出现第一个结点就重复的情况
        ListNode dummyNode = new ListNode(-1, head);

        // 前一个结点
        ListNode preNode = dummyNode;

        // 从虚拟头结点出发，为啥不直接 ListNode preNode = dummyNode.next;
        // 因为第一个结点有可能重复呀。
        while (preNode.next != null && preNode.next.next != null) {
            // 当前值
            int curVal = preNode.next.val;
            // next值
            int nextVal = preNode.next.next.val;

            // 两种情况，
            if(curVal != nextVal){
                // 当前值与next值不同
                // curNode.next可以正常指向，无需改变，也就是后移一位。
                preNode = preNode.next;
            }else{
                // 相同
                // 就得循环找到不同的值为止
                do {
                    // 跳过当前结点
                    preNode.next = preNode.next.next;
                }while (preNode.next != null && preNode.next.val == curVal);

            }
        }
        return dummyNode.next;
    }
}