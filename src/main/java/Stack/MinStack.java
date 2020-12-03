package Stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 定义栈的数据结构，请
 * 在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack =new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.isEmpty()||x<=minStack.peek())
            minStack.push(x);

        stack.push(x);

    }

    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }


    @Test
    public void test(){
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(2);
        stack.push(3);
        int min1 = stack.min();
        stack.pop();
        stack.min();
        stack.pop();
        stack.min();
    }
}
