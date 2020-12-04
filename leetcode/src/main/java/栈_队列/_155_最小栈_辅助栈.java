package 栈_队列;

import java.util.ArrayDeque;

/**
 * @author Tiger
 * @date 2020/11/22 19:58
 */
public class _155_最小栈_辅助栈 {
    private ArrayDeque<Integer> normalStack = new ArrayDeque<Integer>();
    private ArrayDeque<Integer> minStack = new ArrayDeque<Integer>();

    public _155_最小栈_辅助栈() {

    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = minStack.peek();
            if (min < x) {
                minStack.push(min);
            } else {
                minStack.push(x);
            }
        }
        normalStack.push(x);
    }

    public void pop() {
        normalStack.pop();
        minStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
