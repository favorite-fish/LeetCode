package com.ygt.day13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 * @author ygt
 * @since 2024/8/24
 */
public class MyStack {

    // 两个队列
    Queue<Integer> queue;
    Queue<Integer> queue2;

    public MyStack() {
        // 初始化两个队列
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 将元素 x 压入栈顶。
    public void push(int x) {
        // 先插入到queue2队列中
        queue2.offer(x);
        // 在通过将queue的元素取出，补充到queue2队列的末尾
        while (!queue.isEmpty()) {
            queue2.offer(queue.poll());
        }
        // 交换两个队列的角色
        Queue<Integer> temp = queue;
        queue = queue2;
        queue2 = temp;
    }

    // 移除并返回栈顶元素。
    public int pop() {
        return queue.poll();
    }

    // 返回栈顶元素。
    public int top() {
        return queue.peek();
    }

    // 如果栈是空的，返回 true ；否则，返回 false 。
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}