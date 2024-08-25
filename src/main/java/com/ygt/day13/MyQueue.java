package com.ygt.day13;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * @author ygt
 * @since 2024/8/24
 */
class MyQueue {

    // 两个栈
    Deque<Integer> stack;
    Deque<Integer> stack2;


    public MyQueue() {
        stack = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    // 将元素 x 推到队列的末尾
    public void push(int x) {
       stack.push(x);
    }

    // 从队列的开头移除并返回元素
    public int pop() {
        // 取出stack2的数据
        if(stack2.isEmpty()) {
            transfer();
        }
        return stack2.pop();
    }

    // 返回队列开头的元素
    public int peek() {
        // 取出stack2的数据
        if(stack2.isEmpty()) {
            transfer();
        }
        return stack2.peek();
    }

    // 如果队列为空，返回 true ；否则，返回 false
    public boolean empty() {
        return stack.isEmpty() && stack2.isEmpty();
    }

    public void transfer(){
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
    }
}