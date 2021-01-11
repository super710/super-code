package Number;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 */
public class MedianFinder {

    Queue<Integer> A, B;

    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if(A.size()!=B.size()){
            A.add(num);
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }

    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
