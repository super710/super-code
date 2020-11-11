package offer;

import java.util.Stack;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/11
 */

class CQueue {

    /**
     * 剑指 Offer 09. 用两个栈实现队列
     */

    /**
     * 使用双栈，一个负责插入，另一个负责删除，当删除的栈为空的时候将插入的栈全部放入删除的栈，
     * 在删除的栈中pop
     */
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.empty() ? -1 : stack2.pop();
    }
}

public class YongLiangGeZhanShiXianDuiLieLlcof {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(6);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
