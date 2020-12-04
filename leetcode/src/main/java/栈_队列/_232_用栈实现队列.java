package src.main.java.栈;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Tiger
 * @date 2020/11/14 8:36
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232_用栈实现队列 {
    private static Stack<Integer> inStack = new Stack<>();
    private static Stack<Integer> outStack = new Stack<>();

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    public static void main(String[] args) {
        _232_用栈实现队列 v = new _232_用栈实现队列();
        System.out.println(v.empty());
    }
}
