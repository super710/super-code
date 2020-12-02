package offer;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/2
 */
public class MinStack {
    /**
     * 剑指 Offer 30. 包含min函数的栈
     */

    /**
     * 使用辅助栈，如果当前值小于等于之前的最小值将当前值存入辅助栈，删除的时候
     * 如果辅助栈的和原来的栈的值相同同时pop
     */

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty() && stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
//        minStack.pop();
//        System.out.println(minStack.min());
    }
}
