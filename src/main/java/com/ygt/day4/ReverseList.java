package com.ygt.day4;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/description/
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @author ygt
 * @since 2024/8/14
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        // 打印查看当前效果
        ListNode.print(node);

        ListNode listNode = new ReverseList().reverseList(node);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(listNode);
    }

    // 遍历反转单链表
    public ListNode reverseList(ListNode head) {
        /*
        这道题的主要思路，实现关键也是双指针的应用：
            1. 创建两个指针，curNode指针保存当前的head节点数据，preNode节点指针指向null；
            2. 并循环判断当前节点是否为null；
            3. 如果为空，就反转结束，退出循环；
            4. 如果不为空，就进行循环获取当前的节点的下一个节点，并将当前节点的next指针指向下一个节点；
            5. 最终完成链表的反转。
         */

        // 通过双指针迭代法， preNode指针执行null，curNode执行head节点，在判断curNode还未为null时，一直迭代遍历，
        // 不断指针往前移动，并在移动过程中，curNode的next指针指向preNode代表反转。

        // 前结点为null
        ListNode preNode = null;
        // 当前的结点
        ListNode curNode = head;
        // 增加一个保存下一个结点的结点指针
        ListNode nextNode = null;

        // 判断当前结点是否为null，只要还没指向null，一直遍历，当前结点指针往前移
        while(curNode != null) {
            // 获取当前结点的next，避免反转后找不到，并在最后赋值为curNode，实现结点指针一直往前移动
            nextNode = curNode.next;

            // 将当前的结点的next指针指向preNode，相当于反转
            curNode.next = preNode;

            // 重置双指针操作。
            // 赋值前结点为当前节点
            preNode = curNode;
            // 最后赋值当前的节点为next结点
            curNode = nextNode;
        }

        // 最后返回前一个结点，即原链表的最后一个结点，即5
        return preNode;
    }
}
