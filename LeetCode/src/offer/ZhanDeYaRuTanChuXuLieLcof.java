package offer;

import java.util.Stack;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/3
 */
public class ZhanDeYaRuTanChuXuLieLcof {

    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     */

    /**
     * 自己的方法实现一个查找入栈数组中的下标的方法，实现一个辅助栈，将小于当前index的
     * 数据放入栈中，当下一个下标小于当前下标时出栈比较，不相同就返回false
     *
     * 看到答案方法是实现一个辅助栈，按顺序入栈的同时模仿出栈，最后栈为空则返回true
     * 否则返回false
     */

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        if (length == 0) {
            return true;
        }
        Stack<Integer> push = new Stack<>();
        int index = -1;
        for (int i = 0; i < length; i++) {
            int nextIndex = find(pushed, length, popped[i]);
            if (nextIndex < index && (push.empty() || push.pop() != popped[i])){
                return false;
            }
            for (; index + 1 < nextIndex; index++){
                push.push(pushed[index + 1]);
            }
            index = Math.max(index, nextIndex);
        }
        return true;
    }

    static int find(int[] pushed, int length, int num) {
        for (int i = 0; i < length; i++) {
            if (pushed[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.empty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences1(new int[]{1, 0, 3, 2}, new int[]{0, 1, 2, 3}));
    }
}
