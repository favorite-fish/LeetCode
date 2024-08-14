package com.ygt.day4;

public class ListNode {
    int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 打印
    public static void print(ListNode node) {
        ListNode cur = node;
        if (cur != null) {
            System.out.print(cur.val + " --> ");
            ListNode next = cur.next;
            print(next);
        }else {
            System.out.print("null");
        }
    }
}