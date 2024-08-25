package com.ygt.day13;

/**
 * 622. 设计循环队列
 * https://leetcode.cn/problems/design-circular-queue/description/
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，
 * 即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * 示例：
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * @author ygt
 * @since 2024/8/24
 */
public class MyCircularQueue {

    // 基础属性
    private int front;
    private int rear;
    private int size;
    private int[] arr;

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);


        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.deQueue());
        System.out.println(queue.Rear());
        System.out.println(queue.Front());
    }

    // 构造方法
    public MyCircularQueue(int k) {
        // 默认数组的大小比传进来的K+1，因为浪费了一个空间
        size = k + 1;

        // 创建数组
        arr = new int[size];

        // 默认队首和对尾都指向0
        front = rear = 0;
    }

    // 向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if(isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }

    // 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front + 1) % size;
        return true;
    }

    // 从队首获取元素。如果队列为空，返回 -1 。
    public int Front() {
        if(isEmpty()) return -1;

        return arr[front];
    }

    // 获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if(isEmpty()) return -1;

        return arr[(rear - 1 + size) % size];
    }

    // 检查循环队列是否为空。
    public boolean isEmpty() {
        return front == rear;
    }

    // 检查循环队列是否已满。
    public boolean isFull() {
        return front == (rear + 1) % size;
    }
}