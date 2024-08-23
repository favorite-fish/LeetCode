package com.ygt.day12;

import com.ygt.day4.ListNode;

/**
 * 206. 反转链表
 * 使用递归方式来解决这道题
 * @author ygt
 * @since 2024/8/23
 */
public class ReverseList {
    public static void main(String[] args) {
        // 测试反转链表
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // 打印查看当前效果
        ListNode.print(node);

        ListNode list = new ReverseList().reverseList(node);
        System.out.println();

        // 打印查看当前效果
        ListNode.print(list);
    }

    // 递归
    public ListNode reverseList(ListNode head) {
        // 递归方法中，通过递归双重奏：
        // 1. 明确的知道递归的终止条件
        //   在循环遍历的过程中，我们知道只有在null时，就相当于遍历到末尾，就相当于head=null或者head.next=null都算是找到链表最末尾的数据了。
        if(head == null || head.next == null) {
            // 解释下：如果为空链表时，head进来就为空了，直接返回
            // 如果链表为1个的话，也是没有必要进入递归的，只有两个以上才有递归的必要性
            return head;
        }

        //2. 当前函数需要做什么事情，提取重复的逻辑，不断缩小问题规模的一个关系表达式
        // 获取head.下一节点，调用递推公式反转当前结点之后的所有节点，得到当前节点curNode后，逐层返回上级，
        // 并使head.next.next = head;

        //  不断以head.next调用方法，最后返回的结果是反转后的链表的头结点
        ListNode curNode = reverseList(head.next);
        // 怎么理解这段呢
        // 当前链表为1 --> 2 --> 3 --> 4 --> 5 --> null，并且已经找到递归终止条件了，
        // 所以当前curNode为5，head为4，那要怎么反转呢，就是将5结点指向4吧，
        // 所以 4.next.next = 4 ==> 5.next = 4
        // 为什么不curNode.next = head呢，因为curNode是固定返回5结点了，只有head会随着递归层级返回。
        head.next.next = head;

        // 最后，需要将head.next = null，不然链表会变成循环链表了。
        head.next = null;
        // 要最后返回出去的结点得是5，但是你head随着递归是会变化的，而curNode可以固定。
        // 所以每层递归函数返回都是curNode，即最后一个结点5，也就是反转链表后的头结点5
        return curNode;
    }
}
