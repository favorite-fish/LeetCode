package com.ygt.day4;

/**
 * 237. 删除链表中的节点
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/description/
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 * 给定节点的值不应该存在于链表中。
 * 链表中的节点数应该减少 1。
 * node 前面的所有值顺序相同。
 * node 后面的所有值顺序相同。
 * 自定义测试：
 * 对于输入，你应该提供整个链表 head 和要给出的节点 node。node 不应该是链表的最后一个节点，而应该是链表中的一个实际节点。
 * 我们将构建链表，并将节点传递给你的函数。
 * 输出将是调用你函数后的整个链表。
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 *
 * @author ygt
 * @since 2024/8/14
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(9);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode node = new ListNode(4, node2);

        ListNode.print(node);
        new DeleteNode().deleteNode(node3);
        System.out.println();
        ListNode.print(node);

    }
    public void deleteNode(ListNode node) {
        // 因为无法获取到head，也就是无法获取到前一个结点，并且题目保证给定的节点 node 不是链表中的最后一个节点。
        // 那么这道题思路是这样的：将自己包装成下一个结点 就可以很简单写出来了
        // 当前结点的值替换为下一个结点的值
        node.val = node.next.val;
        // 然后当前结点next指针直接指向后一个结点
        node.next = node.next.next;
        // 搞定！！
    }
}
