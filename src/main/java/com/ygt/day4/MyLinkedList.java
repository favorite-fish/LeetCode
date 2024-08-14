package com.ygt.day4;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/description/
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 * 输入
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * 输出
 * [null, null, null, null, 2, null, 3]
 * 解释
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
 * myLinkedList.get(1);              // 返回 2
 * myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
 * myLinkedList.get(1);              // 返回 3
 * @author ygt
 * @since 2024/8/14
 */
public class MyLinkedList {

    /*
       单链表：
       一个单链表中可能会存在多个结点，其每个结点由两部分构成：
        - `val`域：数据域，用来存储元素数据；
        - `next`域：存放结点的直接后继的地址（位置）的指针域，用于指向下一结点；
        - 当链表后续无数据时，一般来说都是最后一个节点指针域指向null代表单链表的结束。
       这里就简单构造下单链表
       下面的方法也是常见的链表的使用方法
    */
    // 既然要有结点，那么先创建一个内部结点类
    class Node{
        //  - `val`域：数据域，用来存储元素数据；
        int val;

        //  - `next`域：存放结点的直接后继的地址（位置）的指针域，用于指向下一结点；
        Node next;

        // 构造方法
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // 在链表中，需要一些必要的属性信息
    // 头结点
    Node head;
    // 链表大小
    int size;

    // 下面开始编写方法
    public MyLinkedList() {
        // 初始化类
        size = 0;
        // 初始化时可以有虚拟头结点和普通头结点的方法。
        // 虚拟头结点是额外增加一个没有值的结点在链表头部，但是链表大小不加一，在一些算法题目很实用。
        // 普通头结点，也就是在原来链表上进行操作，区别在于，创建第一个结点时，普通头结点就是第一个结点，
        // 而虚拟头结点就是原本第一个结点，而创建第一个结点是虚拟头结点的下一个结点。
        // 下面使用虚拟头结点方法
        head = new Node(-1);
    }

    // 这是获取方法，根据索引取出链表的位置。
    public int get(int index) {
        // 需要注意如果包含了虚拟头结点
        // 临界值判断
        if(index < 0 || index >= size) {
            return -1;
        }

        // 查询链表指定位置的元素 是需要遍历链表即遍历每个元素
        // 从索引0处开始遍历，从虚拟头结点的下一个结点的元素开始遍历 。
        // 如 虚拟头结点 --> 0 --> 1 --> 2 现在要查找index为1的位置，即 1的结点的元素。

        // 1. 从虚拟头结点的下一个结点开始 即真正索引为0处。
        Node curNode = head.next; // 即当前为0

        // 2. 开始遍历链表，直到找到index的位置。 现在需要查找到index为1的位置
        for (int i = 0; i < index; i++) {
            // 每次循环，都需要将当前的结点指向下一个结点，直到找到index位置。
            curNode = curNode.next;  // 即循环一次就可以找到 1结点的位置了。
        }

        //  最终获得到curNode.val就是我们想要获取到的元素。
        return curNode.val;

    }

    // 头插法
    public void addAtHead(int val) {
        // 例如： 虚拟 --> 1，头插一个0的数据， 所以为 虚拟 --> 0 --> 1

        // 新建一个结点接收当前数据, 并指向虚拟结点的下一个结点位置。
        // 即 0 --> 1  temp 结点指向 1结点。
        Node temp = new Node(val, head.next);

        // 然后虚拟结点需要指向当前的temp结点。后续的结点无需操作。
        head.next = temp;

        // 可以简写一步为：
        //        head.next = new Node(val, head.next);

        // 链表的长度 + 1
        size++;
    }

    // 尾插法
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 任意位置插入
    public void addAtIndex(int index, int val) {
        // 检验位置的合法性： 如果指定的索引位置不符合要求，抛出异常
        // 切记，index是可以取到size和0的位置，即在链表的尾部添加一个元素或者头部添加一个元素
        if (index < 0 || index > size) {
            return ;
        }

        // 如果是索引是0，我们可以直接使用头插法
        if (index == 0) {
            addAtHead(val);
            return;
        }

        // 如果索引是0之后的数据，需要确定的结点是待插入位置的结点位置
        // 如: 原结点为：虚拟结点 --> 0 --> 2  三个结点（0, 1, 2），现在需要插入位置为1处，所以需要找到1前面的一个数即0的位置
        // 而我们有个虚拟结点，所以需要循环的次数就是index次即 for(int i = 0; i < index; i ++) 找到0处的结点，
        // 然后0.next = 当前带插入的数据temp, 当前待插入的数据temp.next = 2的结点
        //   最终结点为：虚拟结点 --> 0 --> 1 --> 2

        // 1. 确定带插入新元素结点之前的那个结点是谁。
        // 创建一个Node结点prev，初始化的时候指向虚拟头结点head。虚拟节点在开始的时候指向的是0这个索引位置的元素它之前的那个节点。
        Node prev = head;

        // 循环确定处真正需要待插入位置的结点之前的那个结点是谁。
        for (int i = 0; i < index; i++) {
            // 从0开始遍历，将prev的下一个节点prev.next指向prev，即prev向后移动，直到找到待插入节点的前一个节点的位置。
            prev = prev.next;
        }

        // 2. 确定好位置后，就跟之前的插入头结点的方式一样，
        // 新建一个结点接收当前数据, 并指向当前确定的prev结点的下一个结点位置。
        // temp 结点指向 2结点。即 1 --> 2
        Node temp = new Node(val, prev.next);

        // 然后当前确定的prev结点需要指向当前的temp结点。 即 0 --> 1
        prev.next = temp;

        // 可以简写一步为：
        //        prev.next = new Node(val, prev.next);

        // 最后，链表的长度需要 + 1
        size++;
    }

    public void deleteAtIndex(int index) {
        // 需要先校验需要删除的位置是否存在。
        if (index < 0 || index >= size) {
            return;
        }

        // 删除的逻辑，其实和我们的插入元素的逻辑一般，
        // 如: 原结点为：虚拟结点 --> 0 --> 1 --> 2  四个结点（0, 1, 2, 3），现在需要删除位置为1处，所以需要找到1前面的一个数即0的位置
        // 而我们有个虚拟结点，所以需要循环的次数就是index次即 for(int i = 0; i < index; i ++) 找到0处的结点，
        // 然后0.next = 2, 将0结点的next域指向2的结点就行了，1这个结点就没有人去指向，就被删除了
        //   最终结点为：虚拟结点 --> 0 --> 2

        // 1. 确定带删除元素结点之前的那个结点是谁。
        // 创建一个Node结点prev，初始化的时候指向虚拟头结点head。虚拟节点在开始的时候指向的是0这个索引位置的元素它之前的那个节点。
        Node pre = head;

        // 循环遍历，找到待删除元素结点的前一个节点位置
        for (int i = 0; i <= index - 1; i++) {
            pre = pre.next;
        }

        // 2. 确定好位置后，可以得到待删除元素的结点
        Node delNode = pre.next; // 得到1结点。

        // 将待删除元素结点的前一个结点的next指向待删除元素结点的next结点位置上。即0 --> 2 0结点去指向2结点
        pre.next = delNode.next;

        // 最后，链表的长度需要 - 1
        size--;

    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);
    }
}