package 剑指Offer;

import java.util.ArrayDeque;

/**
 * @author Tiger
 * @date 2020/11/28 16:29
 */
public class 用两个栈实现队列 {

    private static ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
    private static ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>();

    public void appendTail(int value) {
        arrayDeque1.push(value);
    }

    public int deleteHead() {
        if (arrayDeque2.isEmpty()) {
            while (!arrayDeque1.isEmpty()) {
                arrayDeque2.push(arrayDeque1.pop());
            }
        }
        if (arrayDeque2.isEmpty()) {
            return -1;
        }
        return arrayDeque2.pop();
    }
}
